package com.api.chezz.exceptions;

public class UserAlreadyLoggedException extends RuntimeException{

    public UserAlreadyLoggedException() {
        super("Usuario já está logado!");
    }
}
