package com.phexum.formHandler.domain.account.usecase.handler;

import com.phexum.formHandler.domain.account.model.AccountModel;
import com.phexum.formHandler.domain.account.port.AccountRepositoryPort;
import com.phexum.formHandler.domain.account.service.AccountService;
import com.phexum.formHandler.domain.account.usecase.AccountUpdateUseCase;
import com.phexum.formHandler.domain.common.DomainComponent;
import com.phexum.formHandler.domain.common.exception.AccountNotFoundException;
import com.phexum.formHandler.domain.common.usecase.ObservableUseCaseHandler;
import com.phexum.formHandler.domain.common.usecase.UseCaseHandler;
@DomainComponent
public class AccountUpdateUseCaseHandler extends ObservableUseCaseHandler implements UseCaseHandler<AccountModel, AccountUpdateUseCase> {
    private final AccountService service;
    private final AccountRepositoryPort repository;

    public AccountUpdateUseCaseHandler(AccountService service, AccountRepositoryPort repository) {
        this.service = service;
        this.repository = repository;
        register(AccountUpdateUseCase.class,this);
    }

    @Override
    public AccountModel handle(AccountUpdateUseCase usecase) {
        if (!service.checkEmailExist(usecase.getAccount().getEmail())) {
            throw new AccountNotFoundException("Account not found");
        }
        return repository.update(usecase.getAccount());
    }

}
