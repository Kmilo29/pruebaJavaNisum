package com.nisum.test.exception;

public class RegisterErrorResponse {

	private String message;
	
	public RegisterErrorResponse() {}

	public RegisterErrorResponse(String message) { 
		super();
		this.message = message;
	}
 
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
