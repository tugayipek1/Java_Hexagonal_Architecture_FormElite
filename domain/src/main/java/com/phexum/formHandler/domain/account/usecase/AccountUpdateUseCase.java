package com.phexum.formHandler.domain.account.usecase;

import com.phexum.formHandler.domain.account.model.AccountModel;
import com.phexum.formHandler.domain.common.usecase.UseCase;

public class AccountUpdateUseCase implements UseCase {
    private AccountModel account;

    public AccountUpdateUseCase() {
    }

    public AccountUpdateUseCase(AccountModel account) {
        this.account = account;
    }

    public AccountModel getAccount() {
        return account;
    }
}
