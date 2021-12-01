package com.phexum.formHandler.domain.common.exception;

public class QuotaOutOfBoundsException extends RuntimeException{
    public QuotaOutOfBoundsException(String message) {
        super(message);
    }
}
