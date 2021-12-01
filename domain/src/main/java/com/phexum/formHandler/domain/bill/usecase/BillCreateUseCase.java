package com.phexum.formHandler.domain.bill.usecase;

import com.phexum.formHandler.domain.account.model.AccountModel;
import com.phexum.formHandler.domain.bill.model.BillModel;
import com.phexum.formHandler.domain.common.usecase.UseCase;

public class BillCreateUseCase implements UseCase {
    AccountModel account;

    public BillCreateUseCase() {
    }

    public BillCreateUseCase(AccountModel account) {
        this.account = account;
    }

    public AccountModel getAccount() {
        return account;
    }
}
