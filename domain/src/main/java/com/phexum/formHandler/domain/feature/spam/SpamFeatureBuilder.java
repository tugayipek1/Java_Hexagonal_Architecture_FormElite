package com.phexum.formHandler.domain.feature.spam;

import com.phexum.formHandler.domain.account.model.AccountType;

public class SpamFeatureBuilder {
    private AccountType accountType;

    public SpamFeatureBuilder accountType (AccountType accountType) {
        this.accountType = accountType;
        return this;
    }

    public SpamFeature build(){
        if (this.accountType==AccountType.FREE){
            return new FreeSpamFeature();
        }else if(this.accountType==AccountType.PRO){
            return new ProSpamFeature();
        }else{
            return new UltimateSpamFeature();
        }
    }
}
