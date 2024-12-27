package com.api.chezz.exceptions;

public class EmailNotFoundException extends RuntimeException{
    public EmailNotFoundException() {
        super("Este email não existe!");
    }
}
