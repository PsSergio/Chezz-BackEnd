package com.api.chezz.exceptions;

public class SessionExpiredException extends RuntimeException{
    public SessionExpiredException() {
        super("Sessão expirada!");
    }
}
