package com.phexum.formHandler.domain.account.usecase;

import com.phexum.formHandler.domain.account.model.AccountModel;
import com.phexum.formHandler.domain.common.usecase.UseCase;

public class AccountGetByIdUseCase implements UseCase {

    private long id;

    public AccountGetByIdUseCase() {
    }

    public AccountGetByIdUseCase(long id) {
        this.id = id;
    }


    public long getId() {
        return id;
    }
}
