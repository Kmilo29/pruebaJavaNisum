package com.nisum.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nisum.test.dto.RegisterDTO;
import com.nisum.test.dto.UserDTO;
import com.nisum.test.exception.CodeAreaPhoneException;
import com.nisum.test.exception.EmailAlreadyCreateException;
import com.nisum.test.exception.EmailFormatException;
import com.nisum.test.exception.PasswordFormatException;
import com.nisum.test.exception.UserInformationException;
import com.nisum.test.service.RegisterService;

@RestController(value = "registerController")
public class RegisterController {

	@Autowired
	private RegisterService service;

	@PostMapping("/register")
	public ResponseEntity<RegisterDTO> addRegister(@RequestBody UserDTO user) throws EmailFormatException,
			PasswordFormatException, EmailAlreadyCreateException, UserInformationException, CodeAreaPhoneException {
		return new ResponseEntity<RegisterDTO>(service.addRegister(user), HttpStatus.OK);
	}
	
}
