package com.phexum.formHandler.domain.account.usecase;

import com.phexum.formHandler.domain.account.model.AccountModel;
import com.phexum.formHandler.domain.common.usecase.UseCase;

public class AccountRegisterationUseCase implements UseCase {
    private AccountModel account;

    public AccountRegisterationUseCase(){}
    public AccountRegisterationUseCase(AccountModel model) {
        this.account = account;

    }


    public AccountModel getAccount() {
        return account;
    }
}
