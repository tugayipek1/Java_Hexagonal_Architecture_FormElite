package com.phexum.formHandler.domain.form.usecase.handler;

import com.phexum.formHandler.domain.common.DomainComponent;
import com.phexum.formHandler.domain.common.usecase.ObservableUseCaseHandler;
import com.phexum.formHandler.domain.common.usecase.UseCaseHandler;
import com.phexum.formHandler.domain.form.model.FormModel;
import com.phexum.formHandler.domain.form.port.FormRepositoryPort;
import com.phexum.formHandler.domain.form.usecase.FormGetAllByAccountUsecase;

import java.util.List;
@DomainComponent
public class FormGetAllByAccountUsecaseHandler extends ObservableUseCaseHandler implements UseCaseHandler<List<FormModel>, FormGetAllByAccountUsecase> {

    private final FormRepositoryPort formRepository;

    public FormGetAllByAccountUsecaseHandler(FormRepositoryPort formRepository) {
        this.formRepository = formRepository;
        register(FormGetAllByAccountUsecase.class,this);
    }

    @Override
    public List<FormModel> handle(FormGetAllByAccountUsecase usecase) {

        return formRepository.getAllByAccount(usecase.getAccount());
    }
}
