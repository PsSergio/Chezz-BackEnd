package com.api.chezz.exceptions;

public class UserAlreadyInMatchException extends RuntimeException{
    public UserAlreadyInMatchException() {
        super("Usuário já está em uma partida!");
    }
}
