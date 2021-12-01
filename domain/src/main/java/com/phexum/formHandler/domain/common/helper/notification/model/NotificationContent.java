package com.phexum.formHandler.domain.common.helper.notification.model;

import com.phexum.formHandler.domain.account.model.AccountModel;

public class NotificationContent {
    private AccountModel account;

    private String subject;
    private String content;

    public NotificationContent(AccountModel account, String subject, String content) {
        this.account = account;
        this.subject = subject;
        this.content = content;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public AccountModel getAccountModel() {
        return account;
    }

    public void setAccountModel(AccountModel accountModel) {
        this.account = accountModel;
    }
}
