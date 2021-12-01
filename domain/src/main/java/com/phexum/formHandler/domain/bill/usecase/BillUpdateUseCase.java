package com.phexum.formHandler.domain.bill.usecase;

import com.phexum.formHandler.domain.account.model.AccountModel;
import com.phexum.formHandler.domain.bill.model.BillModel;
import com.phexum.formHandler.domain.common.usecase.UseCase;

public class BillUpdateUseCase implements UseCase {
    private BillModel bill;

    public BillUpdateUseCase() {
    }

    public BillUpdateUseCase(BillModel bill) {
        this.bill = bill;
    }

    public BillModel getBill() {
        return bill;
    }
}
