package com.nisum.test.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component(value = "utility")
public class Utility {
	
	@Autowired
	private RegisterServiceConfiguration configuration;
	
	private SimpleDateFormat simpleDateFormat;
	
	private Pattern emailPattern;
	
	private Pattern passwordPattern;
	
	@PostConstruct
	public void init() {
		simpleDateFormat = new SimpleDateFormat(configuration.getDateFormat());
		emailPattern = Pattern.compile(configuration.getEmailFormat());
		passwordPattern = Pattern.compile(configuration.getPasswordFormat());
	}
	
	public String formatDate(Date date) {
		return simpleDateFormat.format(new Date()); 
	}
	
	/**
	 * It allows numeric values from 0 to 9.
	 * Both uppercase and lowercase letters from a to z are allowed.
	 * Allowed are underscore “_”, hyphen “-“, and dot “.”
     * Dot isn't allowed at the start and end of the local part.
     * Consecutive dots aren't allowed.
     * For the local part, a maximum of 64 characters are allowed.
     *
	 * @param email
	 * @return
	 */
	public boolean isEmailFormatValid(String email) {
		return emailPattern.matcher(email).matches();
	}
	
	/**
	 * 
     * Password must contain:
     * at least one digit [0-9].
     * at least one lowercase Latin character [a-z].
     * at least one uppercase Latin character [A-Z].
     * at least one special character like ! @ # & ( ).
     * a length of at least 8 characters and a maximum of 20 characters.
	 *
	 * @param password
	 * @return
	 */
	public boolean isPasswordFormatValid(String password) {
		return passwordPattern.matcher(password).matches();
	}
	
}