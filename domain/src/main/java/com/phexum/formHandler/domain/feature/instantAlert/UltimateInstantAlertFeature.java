package com.phexum.formHandler.domain.feature.instantAlert;

import com.phexum.formHandler.domain.common.helper.notification.port.NotificationSenderPort;

public class UltimateInstantAlertFeature extends InstantAlertFeatureImpl implements InstantAlertFeature {


    public UltimateInstantAlertFeature(NotificationSenderPort notificationSenderPort) {
        super(notificationSenderPort);
    }
}
