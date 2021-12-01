package com.phexum.formHandler.domain.journal.usecase.handler;

import com.phexum.formHandler.domain.common.DomainComponent;
import com.phexum.formHandler.domain.common.exception.JournalNotFoundException;
import com.phexum.formHandler.domain.common.usecase.ObservableUseCaseHandler;
import com.phexum.formHandler.domain.common.usecase.UseCaseHandler;
import com.phexum.formHandler.domain.journal.model.JournalModel;
import com.phexum.formHandler.domain.journal.port.JournalRepositoryPort;
import com.phexum.formHandler.domain.journal.usecase.JournalGetByIdUseCase;
@DomainComponent
public class JournalGetByIdUseCaseHandler extends ObservableUseCaseHandler implements UseCaseHandler<JournalModel, JournalGetByIdUseCase> {

    private final JournalRepositoryPort repository;

    public JournalGetByIdUseCaseHandler(JournalRepositoryPort repository) {
        this.repository = repository;
        register(JournalGetByIdUseCase.class,this);
    }

    @Override
    public JournalModel handle(JournalGetByIdUseCase usecase) {
        return repository.getById(usecase.getId()).orElseThrow(()->new JournalNotFoundException("Journal not found"));
    }
}
