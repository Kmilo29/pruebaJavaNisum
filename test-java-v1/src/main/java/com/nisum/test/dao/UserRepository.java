package com.nisum.test.dao;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nisum.test.model.User;

public interface UserRepository extends JpaRepository<User, UUID> {

	Optional<User> findOneByEmail(String email);
	
}
