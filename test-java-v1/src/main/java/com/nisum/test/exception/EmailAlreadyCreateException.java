package com.nisum.test.exception;

public class EmailAlreadyCreateException extends Exception {

	private static final long serialVersionUID = 5202706505608333883L;
	private String message;
	
	public EmailAlreadyCreateException() {}

	public EmailAlreadyCreateException(String message) {
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
