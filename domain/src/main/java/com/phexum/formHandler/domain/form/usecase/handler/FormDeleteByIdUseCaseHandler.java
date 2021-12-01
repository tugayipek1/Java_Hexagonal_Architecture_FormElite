package com.phexum.formHandler.domain.form.usecase.handler;

import com.phexum.formHandler.domain.common.DomainComponent;
import com.phexum.formHandler.domain.common.exception.FormNotFoundException;
import com.phexum.formHandler.domain.common.usecase.ObservableUseCaseHandler;
import com.phexum.formHandler.domain.common.usecase.VoidUseCaseHandler;
import com.phexum.formHandler.domain.form.model.FormModel;
import com.phexum.formHandler.domain.form.port.FormRepositoryPort;
import com.phexum.formHandler.domain.form.usecase.FormDeleteByIdUseCase;
@DomainComponent
public class FormDeleteByIdUseCaseHandler extends ObservableUseCaseHandler implements VoidUseCaseHandler<FormDeleteByIdUseCase> {

    private final FormRepositoryPort formRepository;

    public FormDeleteByIdUseCaseHandler(FormRepositoryPort formRepository) {
        this.formRepository = formRepository;
        register(FormDeleteByIdUseCase.class,this);
    }

    @Override
    public void handle(FormDeleteByIdUseCase usecase) {

        FormModel form=formRepository.getById(usecase.getId()).orElseThrow(()->new FormNotFoundException("Form not exist"));
        formRepository.deleteById(usecase.getId());
    }
}
