package com.phexum.formHandler.domain.feature.bill;

import com.phexum.formHandler.domain.common.helper.notification.port.NotificationSenderPort;
import com.phexum.formHandler.domain.factory.config.Config;

public class UltimateBillFeature extends BillFeatureImpl implements BillFeature {


    public UltimateBillFeature(NotificationSenderPort notificationSenderPort, Config config) {
        super(config);
    }
}
