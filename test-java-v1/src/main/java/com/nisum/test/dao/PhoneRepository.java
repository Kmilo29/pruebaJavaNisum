package com.nisum.test.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nisum.test.model.Phone;

public interface PhoneRepository extends JpaRepository<Phone, UUID> {

}
