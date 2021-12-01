package com.phexum.formHandler.domain.feature.bill;

import com.phexum.formHandler.domain.common.helper.notification.port.NotificationSenderPort;
import com.phexum.formHandler.domain.factory.config.Config;

public class FreeBillFeature extends BillFeatureImpl implements BillFeature {


    public FreeBillFeature(NotificationSenderPort notificationSenderPort, Config config) {
        super(config);
    }
}
