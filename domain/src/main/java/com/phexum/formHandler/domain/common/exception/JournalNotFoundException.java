package com.phexum.formHandler.domain.common.exception;

public class JournalNotFoundException extends RuntimeException{
    public JournalNotFoundException(String message) {
        super(message);
    }
}
