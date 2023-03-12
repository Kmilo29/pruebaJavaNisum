package com.nisum.test.exception;

public class UserInformationException extends Exception {

	private static final long serialVersionUID = -2113371175595187625L;
	private String message;

	public UserInformationException() {}

	public UserInformationException(String message) {
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
