package com.phexum.formHandler.domain.account.usecase.handler;

import com.phexum.formHandler.domain.account.model.AccountModel;
import com.phexum.formHandler.domain.account.port.AccountRepositoryPort;
import com.phexum.formHandler.domain.account.service.AccountService;
import com.phexum.formHandler.domain.account.usecase.AccountDeleteByIdUseCase;
import com.phexum.formHandler.domain.common.DomainComponent;
import com.phexum.formHandler.domain.common.exception.AccountNotFoundException;
import com.phexum.formHandler.domain.common.exception.FormNotFoundException;
import com.phexum.formHandler.domain.common.usecase.ObservableUseCaseHandler;
import com.phexum.formHandler.domain.common.usecase.VoidUseCaseHandler;
import com.phexum.formHandler.domain.form.model.FormModel;

@DomainComponent
public class AccountDeleteByIdUseCaseHandler extends ObservableUseCaseHandler implements VoidUseCaseHandler<AccountDeleteByIdUseCase> {

    private final AccountService service;
    private final AccountRepositoryPort repository;


    public AccountDeleteByIdUseCaseHandler(AccountService service, AccountRepositoryPort repository) {
        this.service = service;
        this.repository = repository;
        register(AccountDeleteByIdUseCase.class,this);

    }

    @Override
    public void handle(AccountDeleteByIdUseCase usecase) {
        AccountModel account=repository.getById(usecase.getId()).orElseThrow(()->new FormNotFoundException("Account not exist"));
        repository.deleteById(usecase.getId());
    }
}
