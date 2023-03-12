package com.nisum.test.service;

import java.util.List;

import com.nisum.test.dto.LocationDTO;
import com.nisum.test.dto.PhoneDTO;
import com.nisum.test.model.Session;
import com.nisum.test.model.User;

public interface ResultService {

	public List<User> getUsers();

	public List<Session> getSessions();

	public List<LocationDTO> getLocacions();
	
	public List<PhoneDTO> getPhones();
	
	
}
