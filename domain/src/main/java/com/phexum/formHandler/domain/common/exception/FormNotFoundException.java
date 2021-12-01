package com.phexum.formHandler.domain.common.exception;

public class FormNotFoundException extends RuntimeException{
    public FormNotFoundException(String message) {
        super(message);
    }
}
