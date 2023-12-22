package com.estudo.cleanarch.core.exceptions;

public class NotFoundException extends RuntimeException{

    public NotFoundException() {
        super("Company not found");
    }

    public NotFoundException(String message) {
        super(message);
    }
}
