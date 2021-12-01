package com.phexum.formHandler.domain.journal.model;

import com.phexum.formHandler.domain.account.model.AccountModel;

import java.util.Date;

public class JournalModel {
    private long id;
    private String name;
    private AccountModel account;
    private Date createDate;
    private long formCount;

    public JournalModel() {

    }

    public JournalModel(long id, String name, AccountModel account, Date createDate, long formCount) {
        this.id = id;
        this.name = name;
        this.account = account;
        this.createDate = createDate;
        this.formCount = formCount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AccountModel getAccount() {
        return account;
    }

    public void setAccount(AccountModel account) {
        this.account = account;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public long getFormCount() {
        return formCount;
    }

    public void setFormCount(long formCount) {
        this.formCount = formCount;
    }

    @Override
    public String toString() {
        return "JournalModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", account=" + account +
                ", createDate=" + createDate +
                ", formCount=" + formCount +
                '}';
    }
}
