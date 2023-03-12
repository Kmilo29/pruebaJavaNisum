package com.nisum.test.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "register-service")
@Component(value = "registerServiceConfiguration")
public class RegisterServiceConfiguration {
	
	private String dateFormat;
	private String emailFormat;
	private String passwordFormat;
	private String emailFormatError;
	private String passwordFormatError;
	private String emailAlreadyCreateError;
	private String userInformationError;
	private String codeAreaPhoneError;

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public String getEmailFormat() {
		return emailFormat;
	}

	public void setEmailFormat(String emailFormat) {
		this.emailFormat = emailFormat;
	}

	public String getPasswordFormat() {
		return passwordFormat;
	}

	public void setPasswordFormat(String passwordFormat) {
		this.passwordFormat = passwordFormat;
	}

	public String getEmailFormatError() {
		return emailFormatError;
	}

	public void setEmailFormatError(String emailFormatError) {
		this.emailFormatError = emailFormatError;
	}

	public String getPasswordFormatError() {
		return passwordFormatError;
	}

	public void setPasswordFormatError(String passwordFormatError) {
		this.passwordFormatError = passwordFormatError;
	}

	public String getEmailAlreadyCreateError() {
		return emailAlreadyCreateError;
	}

	public void setEmailAlreadyCreateError(String emailAlreadyCreateError) {
		this.emailAlreadyCreateError = emailAlreadyCreateError;
	}

	public String getUserInformationError() {
		return userInformationError;
	}

	public void setUserInformationError(String userInformationError) {
		this.userInformationError = userInformationError;
	}

	public String getCodeAreaPhoneError() {
		return codeAreaPhoneError;
	}

	public void setCodeAreaPhoneError(String codeAreaPhoneError) {
		this.codeAreaPhoneError = codeAreaPhoneError;
	}

}

