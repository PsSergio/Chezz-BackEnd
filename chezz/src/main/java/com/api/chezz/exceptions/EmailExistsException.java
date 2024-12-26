package com.api.chezz.exceptions;

public class EmailExistsException extends RuntimeException{

    public EmailExistsException() {
        super("Este email já existe!");
    }
}
