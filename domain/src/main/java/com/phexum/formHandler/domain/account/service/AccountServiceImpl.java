package com.phexum.formHandler.domain.account.service;

import com.phexum.formHandler.domain.account.model.AccountModel;
import com.phexum.formHandler.domain.account.port.AccountRepositoryPort;
import com.phexum.formHandler.domain.common.DomainComponent;

import java.util.Optional;

@DomainComponent
public class AccountServiceImpl implements AccountService {
    private final AccountRepositoryPort repository;

    public AccountServiceImpl(AccountRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public boolean checkEmailExist(String email) {
        Optional<AccountModel> op = repository.findByEmail(email);
        if (op.isPresent()) {
            return true;
        }
        return false;
    }
}
