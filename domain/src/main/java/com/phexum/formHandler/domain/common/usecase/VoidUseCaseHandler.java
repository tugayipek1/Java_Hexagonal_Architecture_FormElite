package com.phexum.formHandler.domain.common.usecase;

public interface VoidUseCaseHandler<T extends UseCase> {
    void handle(T usecase);
}
