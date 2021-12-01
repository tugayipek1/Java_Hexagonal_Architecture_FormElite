package com.phexum.formelite.infralayer.notificationSender.adapters;

import com.phexum.formHandler.domain.common.helper.notification.model.NotificationContent;
import com.phexum.formHandler.domain.common.helper.notification.port.NotificationSenderPort;
import com.phexum.formelite.infralayer.common.PropertyAccessorService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationSenderAdapter implements NotificationSenderPort {

    private final JavaMailSender javaMailSender;

    private final PropertyAccessorService propertyAccessor;


    public NotificationSenderAdapter(JavaMailSender javaMailSender, PropertyAccessorService propertyAccessor) {
        this.javaMailSender = javaMailSender;
        this.propertyAccessor = propertyAccessor;
    }

    @Override
    public void sendNotification(NotificationContent notificationContent) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(notificationContent.getAccountModel().getEmail());
        mailMessage.setSubject(notificationContent.getSubject());
        mailMessage.setFrom(propertyAccessor.getDefaultMailSender());
        mailMessage.setText(notificationContent.getContent());

        javaMailSender.send(mailMessage);
    }
}
