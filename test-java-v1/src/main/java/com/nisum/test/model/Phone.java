package com.nisum.test.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Phone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	private String number;
	
	@ManyToOne
	@JoinColumn(name = "city_code_id")
	private Location cityCode;

	@ManyToOne
	@JoinColumn(name = "country_code_id")
	private Location countryCode;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Location getCityCode() {
		return cityCode;
	}

	public void setCityCode(Location cityCode) {
		this.cityCode = cityCode;
	}

	public Location getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(Location countryCode) {
		this.countryCode = countryCode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
		
}
