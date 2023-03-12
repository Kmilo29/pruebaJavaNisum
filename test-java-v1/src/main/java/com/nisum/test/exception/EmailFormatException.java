package com.nisum.test.exception;

public class EmailFormatException extends Exception {

	private static final long serialVersionUID = 573778973001691922L;
	private String message;
	
	public EmailFormatException() {}

	public EmailFormatException(String message) {
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
