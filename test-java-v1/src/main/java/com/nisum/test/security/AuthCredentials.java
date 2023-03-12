package com.nisum.test.security;

public record AuthCredentials(String email, String password) {
	public AuthCredentials() {
		this(null, null);
	}
}
