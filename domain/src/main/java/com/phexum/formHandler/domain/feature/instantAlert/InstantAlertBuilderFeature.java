package com.phexum.formHandler.domain.feature.instantAlert;

import com.phexum.formHandler.domain.account.model.AccountType;
import com.phexum.formHandler.domain.common.helper.notification.port.NotificationSenderPort;

public class InstantAlertBuilderFeature {
    private NotificationSenderPort notificationSenderPort;
    private AccountType accountType;

    public InstantAlertBuilderFeature notificationSender(NotificationSenderPort notificationSenderPort) {
        this.notificationSenderPort = notificationSenderPort;
        return this;
    }

    public InstantAlertBuilderFeature accountType(AccountType accountType) {
        this.accountType = accountType;
        return this;
    }

    public InstantAlertFeature build(){
        if(this.accountType==AccountType.FREE){
            return new FreeInstantAlertFeature(this.notificationSenderPort);
        }else if(this.accountType==AccountType.PRO){
            return new ProInstantAlertFeature(this.notificationSenderPort);
        }else{
            return new UltimateInstantAlertFeature(this.notificationSenderPort);
        }
    }
}
