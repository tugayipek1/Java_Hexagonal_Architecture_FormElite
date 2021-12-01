package com.phexum.formHandler.domain.form.usecase.handler;

import com.phexum.formHandler.domain.common.DomainComponent;
import com.phexum.formHandler.domain.common.exception.FormNotFoundException;
import com.phexum.formHandler.domain.common.usecase.ObservableUseCaseHandler;
import com.phexum.formHandler.domain.common.usecase.UseCaseHandler;
import com.phexum.formHandler.domain.form.model.FormModel;
import com.phexum.formHandler.domain.form.port.FormRepositoryPort;
import com.phexum.formHandler.domain.form.usecase.FormGetByIdUseCase;

@DomainComponent
public class FormGetByIdUseCaseHandler extends ObservableUseCaseHandler implements UseCaseHandler<FormModel, FormGetByIdUseCase> {

    private final FormRepositoryPort repository;

    public FormGetByIdUseCaseHandler(FormRepositoryPort repository) {
        this.repository = repository;
        register(FormGetByIdUseCase.class, this);
    }

    @Override
    public FormModel handle(FormGetByIdUseCase usecase) {
        FormModel form = repository.getById(usecase.getId()).orElseThrow(() -> new FormNotFoundException("Form not found"));

        return form;
    }
}
