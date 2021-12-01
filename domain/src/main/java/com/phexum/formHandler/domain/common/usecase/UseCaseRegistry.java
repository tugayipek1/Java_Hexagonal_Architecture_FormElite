package com.phexum.formHandler.domain.common.usecase;

import java.util.HashMap;
import java.util.Map;

public final class UseCaseRegistry {
    public static final UseCaseRegistry REGISTRY = new UseCaseRegistry();

    private final Map<Class<? extends UseCase>, UseCaseHandler<?, ? extends UseCase>> useCaseMap;
    private final Map<Class<? extends UseCase>, VoidUseCaseHandler<? extends UseCase>> voidUseCaseMap;

    private UseCaseRegistry() {
        this.useCaseMap = new HashMap<>();
        this.voidUseCaseMap = new HashMap<>();
    }

    public <R, I extends UseCase> void register(Class<I> useCase, UseCaseHandler<R, I> handler) {
        UseCaseRegistry.REGISTRY.useCaseMap.put(useCase, handler);
    }

    public <I extends UseCase> void register(Class<I> useCase, VoidUseCaseHandler<I> handler) {
        REGISTRY.voidUseCaseMap.put(useCase, handler);
    }

    public UseCaseHandler<?, ? extends UseCase> getUseCaseHandler(Class<? extends UseCase> useCase) {
        return REGISTRY.useCaseMap.get(useCase);
    }

    public VoidUseCaseHandler<? extends UseCase> getVoidUseCaseHandler(Class<? extends UseCase> useCase) {
        return REGISTRY.voidUseCaseMap.get(useCase);
    }
}
