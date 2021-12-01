package com.phexum.formHandler.domain.feature.instantAlert;

import com.phexum.formHandler.domain.common.helper.notification.model.NotificationContent;
import com.phexum.formHandler.domain.common.helper.notification.port.NotificationSenderPort;

public class InstantAlertFeatureImpl implements InstantAlertFeature {

    private final NotificationSenderPort notificationSenderPort;

    public InstantAlertFeatureImpl(NotificationSenderPort notificationSenderPort) {
        this.notificationSenderPort = notificationSenderPort;
    }


    @Override
    public void instantAlert(NotificationContent content) {
        this.notificationSenderPort.sendNotification(content);
    }
}
