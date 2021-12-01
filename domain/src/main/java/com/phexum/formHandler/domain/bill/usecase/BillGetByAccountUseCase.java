package com.phexum.formHandler.domain.bill.usecase;

import com.phexum.formHandler.domain.account.model.AccountModel;
import com.phexum.formHandler.domain.common.usecase.UseCase;

public class BillGetByAccountUseCase implements UseCase {
    private AccountModel account;

    public BillGetByAccountUseCase(){}
    public BillGetByAccountUseCase(AccountModel account) {
        this.account = account;
    }

    public AccountModel getAccount() {
        return account;
    }
}
