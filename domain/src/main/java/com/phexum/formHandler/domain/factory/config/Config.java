package com.phexum.formHandler.domain.factory.config;

public interface Config {
    public boolean getSpam();

    public boolean getJournal();

    public boolean getAutoReply();

    public long getQuota();

    public boolean getInstantAlert();

    public long getBillPrice();
}
