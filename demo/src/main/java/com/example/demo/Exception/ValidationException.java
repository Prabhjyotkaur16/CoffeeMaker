package com.example.demo.Exception;

public class ValidationException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private String message;


    public ValidationException(String message) {
        super(message);
        this.message = message;
    }
}
