package com.nisum.test.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nisum.test.model.Session;

public interface SessionRepository extends JpaRepository<Session, UUID> {

}
