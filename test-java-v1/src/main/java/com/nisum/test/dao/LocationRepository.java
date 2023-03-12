package com.nisum.test.dao;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nisum.test.model.Location;

public interface LocationRepository extends JpaRepository<Location, UUID> {

	Optional<Location> findOneByCode(String code);
	
}
