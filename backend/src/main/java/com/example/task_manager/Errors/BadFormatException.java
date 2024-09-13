package com.example.task_manager.Errors;

public class BadFormatException extends RuntimeException {

    private String message;

    public BadFormatException(String message) {
        super(message);
    }
}
