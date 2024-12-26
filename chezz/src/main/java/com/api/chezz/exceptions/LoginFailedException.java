package com.api.chezz.exceptions;

public class LoginFailedException extends RuntimeException{
    public LoginFailedException() {
        super("Credenciais incorretas!");
    }
}
