package com.phexum.formHandler.domain.form.usecase.handler;

import com.phexum.formHandler.domain.account.port.AccountRepositoryPort;
import com.phexum.formHandler.domain.common.DomainComponent;
import com.phexum.formHandler.domain.common.exception.FormNotFoundException;
import com.phexum.formHandler.domain.common.usecase.ObservableUseCaseHandler;
import com.phexum.formHandler.domain.common.usecase.UseCaseHandler;
import com.phexum.formHandler.domain.form.model.FormGetResponseDto;
import com.phexum.formHandler.domain.form.model.FormModel;
import com.phexum.formHandler.domain.form.model.FormSubmit;
import com.phexum.formHandler.domain.form.model.FormSubmitValue;
import com.phexum.formHandler.domain.form.port.FormRepositoryPort;
import com.phexum.formHandler.domain.form.port.FormSubmitRepositoryPort;
import com.phexum.formHandler.domain.form.port.FormSubmitValueRepositoryPort;
import com.phexum.formHandler.domain.form.usecase.GetFormSubmitValueByFormUseCase;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@DomainComponent
public class GetFormSubmitValueByFormUseCaseHandler extends ObservableUseCaseHandler implements UseCaseHandler<List<FormSubmitValue>, GetFormSubmitValueByFormUseCase> {
    private final FormRepositoryPort formRepository;
    private final AccountRepositoryPort accountRepository;
    private final FormSubmitValueRepositoryPort formSubmitValueRepository;
    private final FormSubmitRepositoryPort formSubmitRepository;

    public GetFormSubmitValueByFormUseCaseHandler(FormRepositoryPort formRepository, AccountRepositoryPort accountRepository, FormSubmitValueRepositoryPort formSubmitValueRepository, FormSubmitRepositoryPort formSubmitRepository) {
        this.formRepository = formRepository;
        this.accountRepository = accountRepository;
        this.formSubmitValueRepository = formSubmitValueRepository;
        this.formSubmitRepository = formSubmitRepository;
        register(GetFormSubmitValueByFormUseCase.class,this);
    }

    @Override
    public List<FormSubmitValue> handle(GetFormSubmitValueByFormUseCase usecase) {
        FormModel form = formRepository.getById(usecase.getFormId()).orElseThrow(() -> new FormNotFoundException("form not found"));

        List<FormSubmit> formsubmits = formSubmitRepository.getByForm(form);
        List<FormSubmitValue> formsubmitvalues = formsubmits
                .stream().flatMap(x-> formSubmitValueRepository.getByFormSubmit(x).stream())
                .collect(Collectors.toList());


        return formsubmitvalues;
    }
}
