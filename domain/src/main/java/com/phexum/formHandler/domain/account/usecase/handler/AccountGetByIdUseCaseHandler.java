package com.phexum.formHandler.domain.account.usecase.handler;

import com.phexum.formHandler.domain.account.model.AccountModel;
import com.phexum.formHandler.domain.account.port.AccountRepositoryPort;
import com.phexum.formHandler.domain.account.service.AccountService;
import com.phexum.formHandler.domain.account.usecase.AccountGetByIdUseCase;
import com.phexum.formHandler.domain.common.DomainComponent;
import com.phexum.formHandler.domain.common.exception.AccountNotFoundException;
import com.phexum.formHandler.domain.common.usecase.ObservableUseCaseHandler;
import com.phexum.formHandler.domain.common.usecase.UseCaseHandler;
@DomainComponent
public class AccountGetByIdUseCaseHandler extends ObservableUseCaseHandler implements UseCaseHandler<AccountModel, AccountGetByIdUseCase> {

    private final AccountService service;
    private final AccountRepositoryPort repository;

    public AccountGetByIdUseCaseHandler(AccountService service, AccountRepositoryPort repository) {
        this.service = service;
        this.repository = repository;
        register(AccountGetByIdUseCase.class,this);
    }

    @Override
    public AccountModel handle(AccountGetByIdUseCase usecase) {
        return repository.getById(usecase.getId()).orElseThrow(() -> new AccountNotFoundException("Account not found"));
    }
}
