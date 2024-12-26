package com.api.chezz.exceptions;

import org.springframework.data.jpa.repository.JpaRepository;

public class UsernameExistsException extends RuntimeException {

    public UsernameExistsException() {
        super("Este nome de usuario já existe!");
    }
}
