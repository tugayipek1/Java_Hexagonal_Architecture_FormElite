package com.phexum.formHandler.domain.form.usecase;

import com.phexum.formHandler.domain.account.model.AccountModel;
import com.phexum.formHandler.domain.common.usecase.UseCase;

public class FormGetAllByAccountUsecase implements UseCase {
    private AccountModel account;

    public FormGetAllByAccountUsecase() {
    }
    public FormGetAllByAccountUsecase(AccountModel account) {
        this.account = account;
    }

    public AccountModel getAccount() {
        return account;
    }
}
