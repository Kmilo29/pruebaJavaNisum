package com.nisum.test.exception;

public class CodeAreaPhoneException extends Exception {

	private static final long serialVersionUID = -5535519754785081700L;
	private String message;

	public CodeAreaPhoneException() {}

	public CodeAreaPhoneException(String message) {
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
