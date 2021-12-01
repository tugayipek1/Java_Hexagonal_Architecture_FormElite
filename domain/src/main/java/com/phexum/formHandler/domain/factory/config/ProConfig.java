package com.phexum.formHandler.domain.factory.config;

public class ProConfig implements Config {
    public final boolean proSpam = false;
    public final boolean proJournal = true;
    public final boolean proAutoReply = true;
    public final long proQuota = 10;
    public final boolean proInstantAlert = false;
    public final long proBillPrice = 5;

    @Override
    public boolean getSpam() {
        return proSpam;
    }

    @Override
    public boolean getJournal() {
        return proJournal;
    }

    @Override
    public boolean getAutoReply() {
        return proAutoReply;
    }

    @Override
    public long getQuota() {
        return proQuota;
    }

    @Override
    public boolean getInstantAlert() {
        return proInstantAlert;
    }

    @Override
    public long getBillPrice() {
        return proBillPrice;
    }
}
