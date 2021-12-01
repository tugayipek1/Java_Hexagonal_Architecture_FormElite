package com.phexum.formHandler.domain.feature.instantAlert;

import com.phexum.formHandler.domain.common.helper.notification.port.NotificationSenderPort;

public class FreeInstantAlertFeature extends InstantAlertFeatureImpl implements InstantAlertFeature {


    public FreeInstantAlertFeature(NotificationSenderPort notificationSenderPort) {
        super(notificationSenderPort);
    }
}
