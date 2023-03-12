package com.nisum.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nisum.test.dto.LocationDTO;
import com.nisum.test.dto.PhoneDTO;
import com.nisum.test.model.Session;
import com.nisum.test.model.User;
import com.nisum.test.service.ResultService;

@RestController(value = "resultController")
public class ResultController {
	
	@Autowired
	private ResultService service;

	@GetMapping("/users")
	public List<User> getUsers() {
		return service.getUsers();
	}
	
	@GetMapping("/sessions")
	public List<Session> getSessions() {
		return service.getSessions();
	}

	@GetMapping("/locations")
	public List<LocationDTO> getLocacions() {
		return service.getLocacions();
	}
	
	@GetMapping("/phones")
	public List<PhoneDTO> getPhones() {
		return service.getPhones();
	}

}
