package com.phexum.formHandler.domain.feature.bill;

import com.phexum.formHandler.domain.account.model.AccountType;
import com.phexum.formHandler.domain.common.helper.notification.port.NotificationSenderPort;
import com.phexum.formHandler.domain.factory.config.ConfigFactoryUtil;

public class BillFeatureBuilder {
    private AccountType accountType;
    private NotificationSenderPort notificationSenderPort;

    public BillFeatureBuilder accountType(AccountType accountType) {
        this.accountType = accountType;
        return this;
    }

    public BillFeatureBuilder notificationSender(NotificationSenderPort notificationSenderPort) {
        this.notificationSenderPort = notificationSenderPort;
        return this;
    }


    public BillFeature build() {
        if (this.accountType == AccountType.FREE) {
            return new FreeBillFeature(this.notificationSenderPort, ConfigFactoryUtil.getFeatureConfig(AccountType.FREE));
        } else if (this.accountType == AccountType.PRO) {
            return new ProBillFeature(this.notificationSenderPort, ConfigFactoryUtil.getFeatureConfig(AccountType.PRO));
        } else {
            return new UltimateBillFeature(this.notificationSenderPort, ConfigFactoryUtil.getFeatureConfig(AccountType.ULTIMATE));
        }
    }
}
