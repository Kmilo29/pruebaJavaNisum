package com.nisum.test.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ControllerAdvice
public class RegisterRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<RegisterErrorResponse> handleException(EmailAlreadyCreateException exception) {
		RegisterErrorResponse error = new RegisterErrorResponse(exception.getMessage());
		return new ResponseEntity<>(error, null, HttpStatus.CONFLICT);
	}
	@ExceptionHandler
	public ResponseEntity<RegisterErrorResponse> handleException(EmailFormatException exception) {
		RegisterErrorResponse error = new RegisterErrorResponse(exception.getMessage());
		return new ResponseEntity<>(error, null, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler
	public ResponseEntity<RegisterErrorResponse> handleException(PasswordFormatException exception) {
		RegisterErrorResponse error = new RegisterErrorResponse(exception.getMessage());
		return new ResponseEntity<>(error, null, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler
	public ResponseEntity<RegisterErrorResponse> handleException(UserInformationException exception) {
		RegisterErrorResponse error = new RegisterErrorResponse(exception.getMessage());
		return new ResponseEntity<>(error, null, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler
	public ResponseEntity<RegisterErrorResponse> handleException(CodeAreaPhoneException exception) {
		RegisterErrorResponse error = new RegisterErrorResponse(exception.getMessage());
		return new ResponseEntity<>(error, null, HttpStatus.CONFLICT);
	}
	
}
