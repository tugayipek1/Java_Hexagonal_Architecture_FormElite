package com.phexum.formHandler.domain.common.helper.notification.port;

import com.phexum.formHandler.domain.common.helper.notification.model.NotificationContent;

public interface NotificationSenderPort {
    void sendNotification(NotificationContent content);
}
