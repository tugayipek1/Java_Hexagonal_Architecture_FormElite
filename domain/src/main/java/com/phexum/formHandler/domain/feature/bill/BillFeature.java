package com.phexum.formHandler.domain.feature.bill;

import com.phexum.formHandler.domain.account.model.AccountModel;
import com.phexum.formHandler.domain.bill.model.BillModel;
import com.phexum.formHandler.domain.factory.config.Config;

public interface BillFeature {
    BillModel createBill(AccountModel account);
}
