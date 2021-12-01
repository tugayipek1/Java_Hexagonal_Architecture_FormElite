package com.phexum.formHandler.domain.factory.config;

public class UltimateConfig implements Config {
    public final boolean ultimateSpam = true;
    public final boolean ultimateJournal = true;
    public final boolean ultimateAutoReply = true;
    public final long ultimateQuota = Long.MAX_VALUE;
    public final boolean ultimateInstantAlert = true;
    public final long ultimateBillPrice = 10;

    @Override
    public boolean getSpam() {
        return ultimateSpam;
    }

    @Override
    public boolean getJournal() {
        return ultimateJournal;
    }

    @Override
    public boolean getAutoReply() {
        return ultimateAutoReply;
    }

    @Override
    public long getQuota() {
        return ultimateQuota;
    }

    @Override
    public boolean getInstantAlert() {
        return ultimateInstantAlert;
    }

    @Override
    public long getBillPrice() {
        return ultimateBillPrice;
    }
}
