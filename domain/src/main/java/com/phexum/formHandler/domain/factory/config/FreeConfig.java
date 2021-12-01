package com.phexum.formHandler.domain.factory.config;

public class FreeConfig implements Config {
    public final boolean freeSpam = false;
    public final boolean freeJournal= false;
    public final boolean freeAutoReply = false;
    public final long freeQuota = 5;
    public final boolean freeInstantAlert = false;
    public final long freeBillPrice = 0;

    @Override
    public boolean getSpam() {
        return freeSpam;
    }

    @Override
    public boolean getJournal() {
        return freeJournal;
    }

    @Override
    public boolean getAutoReply() {
        return freeAutoReply;
    }

    @Override
    public long getQuota() {
        return freeQuota;
    }

    @Override
    public boolean getInstantAlert() {
        return freeInstantAlert;
    }

    @Override
    public long getBillPrice() {
        return freeBillPrice;
    }
}
