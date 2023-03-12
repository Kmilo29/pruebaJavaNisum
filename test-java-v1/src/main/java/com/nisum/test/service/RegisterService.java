package com.nisum.test.service;

import com.nisum.test.dto.RegisterDTO;
import com.nisum.test.dto.UserDTO;
import com.nisum.test.exception.CodeAreaPhoneException;
import com.nisum.test.exception.EmailAlreadyCreateException;
import com.nisum.test.exception.EmailFormatException;
import com.nisum.test.exception.PasswordFormatException;
import com.nisum.test.exception.UserInformationException;

public interface RegisterService {

	RegisterDTO addRegister(UserDTO user) throws EmailFormatException, PasswordFormatException, EmailAlreadyCreateException,
			UserInformationException, CodeAreaPhoneException;

}