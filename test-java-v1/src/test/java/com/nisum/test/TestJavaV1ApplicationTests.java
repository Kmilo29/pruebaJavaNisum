package com.nisum.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nisum.test.dto.PhoneDTO;
import com.nisum.test.dto.UserDTO;
import com.nisum.test.exception.CodeAreaPhoneException;
import com.nisum.test.exception.EmailAlreadyCreateException;
import com.nisum.test.exception.EmailFormatException;
import com.nisum.test.exception.PasswordFormatException;
import com.nisum.test.exception.UserInformationException;
import com.nisum.test.service.RegisterService;

@SpringBootTest
class TestJavaV1ApplicationTests {

	@Autowired
	private RegisterService service;

	private UserDTO user;
	private Set<PhoneDTO> phones;

	@BeforeEach
	public void beforeEach() {
		phones = new HashSet<>();

		phones.add(new PhoneDTO("1234567", "1", "57"));
		phones.add(new PhoneDTO("11111111", "2", "57"));
		phones.add(new PhoneDTO("54879999", "4", "57"));

		user = new UserDTO("Lewis Hamilton", "lewis.hamilton@gmail.com", "AMG123petronasW14*", phones);
	}

	@DisplayName("Add a new user")
	@Test
	public void addUser() throws EmailFormatException, PasswordFormatException, EmailAlreadyCreateException,
			UserInformationException, CodeAreaPhoneException {
		assertNotNull(service.addRegister(user), "object should not be null");
	}

	@DisplayName("Generate EmailFormatException")
	@Test
	public void generateEmailFormatException() throws EmailFormatException, PasswordFormatException,
			EmailAlreadyCreateException, UserInformationException, CodeAreaPhoneException {
		
		user = new UserDTO("Lewis Hamilton", "lewis hamilton@gmail.com", "AMG123petronasW14*", phones);

		assertThrows(EmailFormatException.class, () -> {
			service.addRegister(user);
		});
	}

	@DisplayName("Generate PasswordFormatException")
	@Test
	public void generatePasswordFormatException() throws EmailFormatException, PasswordFormatException,
	EmailAlreadyCreateException, UserInformationException, CodeAreaPhoneException {
		
		user = new UserDTO("Lewis Hamilton", "lewishamilton@gmail.com", "petronas", phones);
		
		assertThrows(PasswordFormatException.class, () -> {
			service.addRegister(user);
		});
	}

	@DisplayName("Generate EmailAlreadyCreateException")
	@Test
	public void generateEmailAlreadyCreateException() throws EmailFormatException, PasswordFormatException,
	EmailAlreadyCreateException, UserInformationException, CodeAreaPhoneException {
		
		user = new UserDTO("Lewis Hamilton", "john.doe@gmail.com", "AMG123petronasW14*", phones);
		
		assertThrows(EmailAlreadyCreateException.class, () -> {
			service.addRegister(user);
		});
	}

	@DisplayName("Generate UserInformationException")
	@Test
	public void generateUserInformationException() throws EmailFormatException, PasswordFormatException,
	EmailAlreadyCreateException, UserInformationException, CodeAreaPhoneException {
		
		user = new UserDTO(null, "lewishamilton@gmail.com", "AMG123petronasW14*", phones);
		
		assertThrows(UserInformationException.class, () -> {
			service.addRegister(user);
		});
	}
	
	@DisplayName("Generate CodeAreaPhoneException for error City code")
	@Test
	public void generateCodeAreaPhoneExceptionCityCode() throws EmailFormatException, PasswordFormatException,
	EmailAlreadyCreateException, UserInformationException, CodeAreaPhoneException {
		phones = new HashSet<>();

		phones.add(new PhoneDTO("1234567", "100", "57"));

		user = new UserDTO("Lewis Hamilton", "lewishamilton@gmail.com", "AMG123petronasW14*", phones);
		
		assertThrows(CodeAreaPhoneException.class, () -> {
			service.addRegister(user);
		});
	}

	@DisplayName("Generate CodeAreaPhoneException for error Country code")
	@Test
	public void generateCodeAreaPhoneExceptionCountryCode() throws EmailFormatException, PasswordFormatException,
	EmailAlreadyCreateException, UserInformationException, CodeAreaPhoneException {
		phones = new HashSet<>();

		phones.add(new PhoneDTO("1234567", "1", "50007"));

		user = new UserDTO("Lewis Hamilton", "lewishamilton@gmail.com", "AMG123petronasW14*", phones);
		
		assertThrows(CodeAreaPhoneException.class, () -> {
			service.addRegister(user);
		});
	}
	
}
