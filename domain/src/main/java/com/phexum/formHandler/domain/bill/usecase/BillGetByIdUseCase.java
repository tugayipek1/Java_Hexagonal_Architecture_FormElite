package com.phexum.formHandler.domain.bill.usecase;

import com.phexum.formHandler.domain.common.usecase.UseCase;

public class BillGetByIdUseCase implements UseCase {

    private long id;
    public BillGetByIdUseCase(){}
    public BillGetByIdUseCase(long id) {
        this.id = id;
    }



    public long getId() {
        return id;
    }
}
