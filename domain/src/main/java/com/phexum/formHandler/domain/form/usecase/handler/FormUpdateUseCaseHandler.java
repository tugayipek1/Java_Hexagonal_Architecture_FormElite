package com.phexum.formHandler.domain.form.usecase.handler;

import com.phexum.formHandler.domain.common.DomainComponent;
import com.phexum.formHandler.domain.common.exception.FormNotFoundException;
import com.phexum.formHandler.domain.common.usecase.ObservableUseCaseHandler;
import com.phexum.formHandler.domain.common.usecase.UseCaseHandler;
import com.phexum.formHandler.domain.form.model.FormModel;
import com.phexum.formHandler.domain.form.port.FormRepositoryPort;
import com.phexum.formHandler.domain.form.service.FormService;
import com.phexum.formHandler.domain.form.usecase.FormUpdateUseCase;
@DomainComponent
public class FormUpdateUseCaseHandler extends ObservableUseCaseHandler implements UseCaseHandler<FormModel, FormUpdateUseCase> {

    private final FormService service;
    private final FormRepositoryPort repository;

    public FormUpdateUseCaseHandler(FormService service, FormRepositoryPort repository) {
        this.service = service;
        this.repository = repository;
        register(FormUpdateUseCase.class,this);
    }

    @Override
    public FormModel handle(FormUpdateUseCase usecase) {

        if (!service.checkFormExistById(usecase.getForm().getId())) {
            throw new FormNotFoundException("Form not found");
        }

        return repository.update(usecase.getForm());
    }
}
