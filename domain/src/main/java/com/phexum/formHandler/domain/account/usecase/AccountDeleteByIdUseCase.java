package com.phexum.formHandler.domain.account.usecase;

import com.phexum.formHandler.domain.account.model.AccountModel;
import com.phexum.formHandler.domain.common.usecase.UseCase;

public class AccountDeleteByIdUseCase implements UseCase {
    private long id;

    public AccountDeleteByIdUseCase(){}
    public AccountDeleteByIdUseCase(long id) {
        this.id = id;
    }



    public long getId() {
        return id;
    }
}
