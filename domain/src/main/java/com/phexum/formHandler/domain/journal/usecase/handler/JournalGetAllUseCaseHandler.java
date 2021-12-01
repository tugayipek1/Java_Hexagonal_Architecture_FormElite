package com.phexum.formHandler.domain.journal.usecase.handler;

import com.phexum.formHandler.domain.common.DomainComponent;
import com.phexum.formHandler.domain.common.usecase.ObservableUseCaseHandler;
import com.phexum.formHandler.domain.common.usecase.UseCaseHandler;
import com.phexum.formHandler.domain.journal.model.JournalModel;
import com.phexum.formHandler.domain.journal.port.JournalRepositoryPort;
import com.phexum.formHandler.domain.journal.usecase.JournalGetAllUseCase;

import java.util.List;
@DomainComponent
public class JournalGetAllUseCaseHandler extends ObservableUseCaseHandler implements UseCaseHandler<List<JournalModel>, JournalGetAllUseCase> {

    private final JournalRepositoryPort repository;

    public JournalGetAllUseCaseHandler(JournalRepositoryPort repository) {
        this.repository = repository;
        register(JournalGetAllUseCase.class,this);
    }

    @Override
    public List<JournalModel> handle(JournalGetAllUseCase usecase) {
        return repository.getAll();
    }
}
