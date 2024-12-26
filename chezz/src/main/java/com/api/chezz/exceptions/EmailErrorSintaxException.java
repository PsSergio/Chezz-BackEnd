package com.api.chezz.exceptions;

public class EmailErrorSintaxException extends RuntimeException{

    public EmailErrorSintaxException() {
        super("Um email deve seguir o exemplo: name@domain.com");
    }
}
