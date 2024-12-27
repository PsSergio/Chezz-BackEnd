package com.api.chezz.exceptions;

public class WrongCodeException extends RuntimeException{
    public WrongCodeException() {
        super("Número de código inválido!");
    }
}
