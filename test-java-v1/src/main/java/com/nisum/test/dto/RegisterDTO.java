package com.nisum.test.dto;

public record RegisterDTO(UserDTO user, String id, String created, String modified, String last_login, String token, Boolean isActive) {

}
