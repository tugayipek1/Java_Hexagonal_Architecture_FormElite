package com.phexum.formHandler.domain.form.model;

import com.phexum.formHandler.domain.account.model.AccountModel;

import java.util.ArrayList;
import java.util.List;

public class FormModel {
    private long id;
    private String name;
    private AccountModel account;


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

}