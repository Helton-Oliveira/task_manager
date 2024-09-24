package com.example.taskMaster.infra.exceptions;

public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}
