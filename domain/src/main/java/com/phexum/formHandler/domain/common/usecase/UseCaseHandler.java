package com.phexum.formHandler.domain.common.usecase;

public interface UseCaseHandler<R, T extends UseCase> {
    R handle(T usecase) ;
}
