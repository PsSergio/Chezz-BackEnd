package com.api.chezz.exceptions;

public class SessionNotFoundException extends RuntimeException {
    public SessionNotFoundException() {
        super("Sessao nao encontrada");
    }
}
