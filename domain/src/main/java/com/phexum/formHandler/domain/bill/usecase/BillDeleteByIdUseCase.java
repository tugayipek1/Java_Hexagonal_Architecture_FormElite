package com.phexum.formHandler.domain.bill.usecase;

import com.phexum.formHandler.domain.common.usecase.UseCase;

public class BillDeleteByIdUseCase implements UseCase {
    private long id;

    public BillDeleteByIdUseCase(){}
    public BillDeleteByIdUseCase(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
