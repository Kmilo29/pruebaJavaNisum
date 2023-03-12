package com.nisum.test.exception;

public class PasswordFormatException extends Exception {

	private static final long serialVersionUID = -7652231523091977337L;
	private String message;

	public PasswordFormatException() {}

	public PasswordFormatException(String message) {
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
