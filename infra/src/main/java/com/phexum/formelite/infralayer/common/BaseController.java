package com.phexum.formelite.infralayer.common;

import com.phexum.formHandler.domain.common.usecase.UseCase;
import com.phexum.formHandler.domain.common.usecase.UseCaseHandler;
import com.phexum.formHandler.domain.common.usecase.UseCaseRegistry;
import com.phexum.formHandler.domain.common.usecase.VoidUseCaseHandler;

import java.util.Objects;

public class BaseController {

    public <T extends UseCase> void handle(T usecase) {
        VoidUseCaseHandler handler = UseCaseRegistry.REGISTRY.getVoidUseCaseHandler(usecase.getClass());
        handler.handle(usecase);
    }

    public <R, T extends UseCase> R handle(Class<R> returnClass, T usecase)  {
        UseCaseHandler handler = UseCaseRegistry.REGISTRY.getUseCaseHandler(usecase.getClass());

        return (R) handler.handle(usecase);
    }
}