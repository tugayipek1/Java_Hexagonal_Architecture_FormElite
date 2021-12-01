package com.phexum.formHandler.domain.journal.usecase.handler;

import com.phexum.formHandler.domain.common.DomainComponent;
import com.phexum.formHandler.domain.common.exception.FormNotFoundException;
import com.phexum.formHandler.domain.common.exception.JournalNotFoundException;
import com.phexum.formHandler.domain.common.usecase.ObservableUseCaseHandler;
import com.phexum.formHandler.domain.common.usecase.VoidUseCaseHandler;
import com.phexum.formHandler.domain.form.model.FormModel;
import com.phexum.formHandler.domain.journal.model.JournalModel;
import com.phexum.formHandler.domain.journal.port.JournalRepositoryPort;
import com.phexum.formHandler.domain.journal.usecase.JournalDeleteByIdUseCase;
@DomainComponent
public class JournalDeleteByIdUseCaseHandler extends ObservableUseCaseHandler implements VoidUseCaseHandler<JournalDeleteByIdUseCase> {

    private final JournalRepositoryPort repository;

    public JournalDeleteByIdUseCaseHandler(JournalRepositoryPort repository) {
        this.repository = repository;
        register(JournalDeleteByIdUseCase.class,this);
    }

    @Override
    public void handle(JournalDeleteByIdUseCase usecase) {
        JournalModel journal=repository.getById(usecase.getId()).orElseThrow(()->new FormNotFoundException("Journal not exist"));
        repository.deleteById(usecase.getId());
    }
}
