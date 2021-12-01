package com.phexum.formHandler.domain.form.usecase.handler;

import com.phexum.formHandler.domain.common.DomainComponent;
import com.phexum.formHandler.domain.common.usecase.ObservableUseCaseHandler;
import com.phexum.formHandler.domain.common.usecase.UseCaseHandler;
import com.phexum.formHandler.domain.form.model.FormModel;
import com.phexum.formHandler.domain.form.port.FormRepositoryPort;
import com.phexum.formHandler.domain.form.usecase.FormCreateUseCase;
@DomainComponent
public class FormCreateUseCaseHandler extends ObservableUseCaseHandler implements UseCaseHandler<FormModel, FormCreateUseCase> {

    private final FormRepositoryPort repository;

    public FormCreateUseCaseHandler(FormRepositoryPort repository) {
        this.repository = repository;
        register(FormCreateUseCase.class,this);
    }

    @Override
    public FormModel handle(FormCreateUseCase usecase) {

        return repository.create(usecase.getForm());
    }
}
