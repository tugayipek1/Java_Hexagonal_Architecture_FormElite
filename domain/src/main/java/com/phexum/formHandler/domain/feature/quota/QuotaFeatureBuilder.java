package com.phexum.formHandler.domain.feature.quota;

import com.phexum.formHandler.domain.account.model.AccountType;
import com.phexum.formHandler.domain.factory.config.ConfigFactoryUtil;

public class QuotaFeatureBuilder {
    private AccountType accountType;

    public QuotaFeatureBuilder accountType (AccountType accountType) {
        this.accountType = accountType;
        return this;
    }


    public QuotaFeature build(){
        if (this.accountType==AccountType.FREE){
            return new FreeQuotaFeature(ConfigFactoryUtil.getFeatureConfig(AccountType.FREE));
        }else if (this.accountType==AccountType.PRO){
            return new ProQuotaFeature(ConfigFactoryUtil.getFeatureConfig(AccountType.PRO));
        }else{
            return new UltimateQuotaFeature(ConfigFactoryUtil.getFeatureConfig(AccountType.ULTIMATE));


        }
    }

}
