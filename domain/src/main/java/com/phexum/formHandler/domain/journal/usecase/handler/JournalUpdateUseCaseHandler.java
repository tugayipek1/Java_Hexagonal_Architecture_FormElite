package com.phexum.formHandler.domain.journal.usecase.handler;

import com.phexum.formHandler.domain.common.DomainComponent;
import com.phexum.formHandler.domain.common.usecase.ObservableUseCaseHandler;
import com.phexum.formHandler.domain.common.usecase.UseCaseHandler;
import com.phexum.formHandler.domain.journal.model.JournalModel;
import com.phexum.formHandler.domain.journal.port.JournalRepositoryPort;
import com.phexum.formHandler.domain.journal.usecase.JournalUpdateUseCase;
@DomainComponent
public class JournalUpdateUseCaseHandler extends ObservableUseCaseHandler implements UseCaseHandler<JournalModel, JournalUpdateUseCase> {
    private final JournalRepositoryPort repository;

    public JournalUpdateUseCaseHandler(JournalRepositoryPort repository) {
        this.repository = repository;
        register(JournalUpdateUseCase.class, this);
    }

    @Override
    public JournalModel handle(JournalUpdateUseCase usecase) {
        return repository.update(usecase.getJournal());
    }
}
