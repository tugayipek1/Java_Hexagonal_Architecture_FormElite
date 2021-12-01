package com.phexum.formHandler.domain.feature.bill;

import com.phexum.formHandler.domain.common.helper.notification.port.NotificationSenderPort;
import com.phexum.formHandler.domain.factory.config.Config;

public class ProBillFeature extends BillFeatureImpl implements BillFeature {


    public ProBillFeature(NotificationSenderPort notificationSenderPort, Config config) {
        super(config);
    }
}
