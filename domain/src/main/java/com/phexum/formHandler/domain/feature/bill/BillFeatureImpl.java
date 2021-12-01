package com.phexum.formHandler.domain.feature.bill;

import com.phexum.formHandler.domain.account.model.AccountModel;
import com.phexum.formHandler.domain.bill.model.BillModel;
import com.phexum.formHandler.domain.factory.config.Config;

import java.util.Date;

public class BillFeatureImpl implements BillFeature {

    private final Config config;

    public BillFeatureImpl(Config config) {

        this.config = config;
    }

    @Override
    public BillModel createBill(AccountModel account) {
        Date date = new Date();

        BillModel bill = new BillModel();
        bill.setCreatedAt(date);
        bill.setPrice(config.getBillPrice());
        bill.setAccount(account);
        bill.setDueDate( Date.from(date.toInstant().plusSeconds(60 * 60 * 24 * 30)));
        bill.setName(date + " Faturası");

        return bill;
    }


}
