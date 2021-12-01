package com.phexum.formHandler.domain.common.exception;

public class BillNotFoundException extends RuntimeException{
    public BillNotFoundException(String message) {
        super(message);
    }
}
