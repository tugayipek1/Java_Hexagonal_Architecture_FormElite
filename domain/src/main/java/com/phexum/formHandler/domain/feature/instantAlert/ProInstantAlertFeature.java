package com.phexum.formHandler.domain.feature.instantAlert;

import com.phexum.formHandler.domain.common.helper.notification.port.NotificationSenderPort;

public class ProInstantAlertFeature extends InstantAlertFeatureImpl implements InstantAlertFeature {


    public ProInstantAlertFeature(NotificationSenderPort notificationSenderPort) {
        super(notificationSenderPort);
    }
}
