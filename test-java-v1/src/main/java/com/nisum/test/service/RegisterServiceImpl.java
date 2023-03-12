package com.nisum.test.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nisum.test.dao.LocationRepository;
import com.nisum.test.dao.PhoneRepository;
import com.nisum.test.dao.SessionRepository;
import com.nisum.test.dao.UserRepository;
import com.nisum.test.dto.PhoneDTO;
import com.nisum.test.dto.RegisterDTO;
import com.nisum.test.dto.UserDTO;
import com.nisum.test.exception.CodeAreaPhoneException;
import com.nisum.test.exception.EmailAlreadyCreateException;
import com.nisum.test.exception.EmailFormatException;
import com.nisum.test.exception.PasswordFormatException;
import com.nisum.test.exception.UserInformationException;
import com.nisum.test.model.Location;
import com.nisum.test.model.Phone;
import com.nisum.test.model.Session;
import com.nisum.test.security.TokenUtils;
import com.nisum.test.util.RegisterServiceConfiguration;
import com.nisum.test.util.Utility;

@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private Utility utility;

	@Autowired
	private RegisterServiceConfiguration messages;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private LocationRepository locationRepository;
	
	@Autowired
	private PhoneRepository phoneRepository;
	
	@Autowired
	private SessionRepository sessionRepository;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@Override
	public RegisterDTO addRegister(UserDTO user)
			throws EmailFormatException, PasswordFormatException, 
			EmailAlreadyCreateException, UserInformationException, 
			CodeAreaPhoneException {
		RegisterDTO register = null;
		List<Phone> phones = new ArrayList<>();
		com.nisum.test.model.User newUser;

		if (user != null) {
			if (!utility.isEmailFormatValid(user.email())) {
				throw new EmailFormatException(messages.getEmailFormatError());
			}

			if (!utility.isPasswordFormatValid(user.password())) {
				throw new PasswordFormatException(messages.getPasswordFormatError());
			}

			if (isEmailCreated(user.email())) {
				throw new EmailAlreadyCreateException(messages.getEmailAlreadyCreateError());
			}

			if (user.name() != null && !user.name().isBlank()) {
				newUser = new com.nisum.test.model.User();
				newUser.setName(user.name());
				newUser.setEmail(user.email());
				newUser.setPassword(encoder.encode(user.password()));
				newUser.setCreated(new Date());
				newUser.setModified(new Date());
				newUser.setLastLogin(new Date());
				newUser.setIsActive(true);
				
			} else {
				throw new UserInformationException(messages.getUserInformationError());
			}
			
			if (user.phones() != null && !user.phones().isEmpty()) {
				for (PhoneDTO phone : user.phones()) {
					Location cityCode = isLocationCodeExist(phone.cityCode());
					Location countryCode = isLocationCodeExist(phone.countryCode());

					if (phone.number() != null && !phone.number().isEmpty() 
							&& cityCode != null && countryCode != null
								&& cityCode.getParent().getId().equals(countryCode.getId())) { 
						Phone newPhone = new Phone();
						newPhone.setUser(newUser);
						newPhone.setNumber(phone.number());
						newPhone.setCityCode(cityCode);
						newPhone.setCountryCode(countryCode);
						phones.add(newPhone);
					} else {
						throw new CodeAreaPhoneException(messages.getCodeAreaPhoneError());
					}
				}
			}
			
			newUser = userRepository.save(newUser);
			
			phones.forEach(phone -> {
				phoneRepository.save(phone);
			});
			
			
			String token = TokenUtils.createToken(user.password(), user.email());
			Session session = new Session();
			session.setUser(newUser);
			session.setToken(token);
			session.setIsActive(true);
			session.setCreated(new Date());
			
			sessionRepository.save(session);

			UserDTO userRegister = new UserDTO(newUser.getName(), newUser.getEmail(), newUser.getPassword(), user.phones());
			
			register = new RegisterDTO(
					userRegister, 
					newUser.getId().toString(), 
					utility.formatDate(newUser.getCreated()), 
					utility.formatDate(newUser.getModified()), 
					utility.formatDate(newUser.getLastLogin()), 
					token, 
					newUser.getIsActive());
		}

		return register;
	}

	private Boolean isEmailCreated(String email) {
		Optional<com.nisum.test.model.User> usuario = userRepository.findOneByEmail(email);
		return usuario.isPresent();
	}

	private Location isLocationCodeExist(String code) {
		Optional<Location> location = locationRepository.findOneByCode(code);
		return location.isPresent() ? location.get() : null;
	}

}
