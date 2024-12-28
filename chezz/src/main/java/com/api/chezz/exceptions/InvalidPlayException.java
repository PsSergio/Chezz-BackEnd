package com.api.chezz.exceptions;

public class InvalidPlayException extends RuntimeException{
    public InvalidPlayException() {
        super("Jogada inválida!");
    }
}
