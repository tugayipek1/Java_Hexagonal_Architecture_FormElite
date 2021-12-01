package com.phexum.formHandler.domain.account.usecase.handler;

import com.phexum.formHandler.domain.account.model.AccountModel;
import com.phexum.formHandler.domain.account.port.AccountRepositoryPort;
import com.phexum.formHandler.domain.account.service.AccountService;
import com.phexum.formHandler.domain.account.usecase.AccountGetAllUseCase;
import com.phexum.formHandler.domain.common.DomainComponent;
import com.phexum.formHandler.domain.common.usecase.ObservableUseCaseHandler;
import com.phexum.formHandler.domain.common.usecase.UseCaseHandler;

import java.util.List;
@DomainComponent
public class AccountGetAllUseCaseHandler extends ObservableUseCaseHandler implements UseCaseHandler<List<AccountModel>, AccountGetAllUseCase> {
    private final AccountService service;
    private final AccountRepositoryPort repository;

    public AccountGetAllUseCaseHandler(AccountService service, AccountRepositoryPort repository) {
        this.service = service;
        this.repository = repository;
        register(AccountGetAllUseCase.class, this);
    }

    @Override
    public List<AccountModel> handle(AccountGetAllUseCase usecase) {
        return repository.getAll();
    }

}
