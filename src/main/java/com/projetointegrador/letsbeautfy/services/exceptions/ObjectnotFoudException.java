package com.projetointegrador.letsbeautfy.services.exceptions;

public class ObjectnotFoudException extends RuntimeException{
    private static final long serialVersionUID = 1l;

    public ObjectnotFoudException(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjectnotFoudException(String message) {
        super(message);
    }
}
