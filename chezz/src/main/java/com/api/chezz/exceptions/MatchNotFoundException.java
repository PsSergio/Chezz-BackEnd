package com.api.chezz.exceptions;

public class MatchNotFoundException extends RuntimeException{
    public MatchNotFoundException() {
        super("Nenhum adversário encontrado para jogar!");
    }
}
