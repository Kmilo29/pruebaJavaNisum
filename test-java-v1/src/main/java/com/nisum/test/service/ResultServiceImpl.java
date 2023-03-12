package com.nisum.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nisum.test.dao.LocationRepository;
import com.nisum.test.dao.PhoneRepository;
import com.nisum.test.dao.SessionRepository;
import com.nisum.test.dao.UserRepository;
import com.nisum.test.dto.LocationDTO;
import com.nisum.test.dto.PhoneDTO;
import com.nisum.test.model.Location;
import com.nisum.test.model.Phone;
import com.nisum.test.model.Session;
import com.nisum.test.model.User;

@Service
public class ResultServiceImpl implements ResultService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SessionRepository sessionRepository;

	@Autowired
	private PhoneRepository phoneRepository;

	@Autowired
	private LocationRepository locationRepository;

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public List<Session> getSessions() {
		return sessionRepository.findAll();
	}

	@Override
	public List<PhoneDTO> getPhones() {
		List<PhoneDTO> phonesDTO = new ArrayList<>();
		List<Phone> phones = phoneRepository.findAll();

		phones.forEach(phone -> {
			phonesDTO.add(
					new PhoneDTO(phone.getNumber(), phone.getCityCode().getCode(), phone.getCountryCode().getCode()));
		});

		return phonesDTO;
	}

	@Override
	public List<LocationDTO> getLocacions() {
		List<LocationDTO> locationsDTO = new ArrayList<>();
		List<Location> locations = locationRepository.findAll();

		locations.forEach(location -> {
			locationsDTO.add(new LocationDTO(location.getType(), location.getCode(), location.getName()));
		});

		return locationsDTO;
	}

}
