package com.phexum.formHandler.domain.bill.model;

import com.phexum.formHandler.domain.account.model.AccountModel;

import java.util.Date;

public class BillModel {
    private long id;
    private String name;
    private Date dueDate;
    private long price;
    private Date createdAt;
    private AccountModel account;

    @Override
    public String toString() {
        return "BillModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dueDate=" + dueDate +
                ", price=" + price +
                ", createdAt=" + createdAt +
                ", account=" + account +
                '}';
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

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public AccountModel getAccount() {
        return account;
    }

    public void setAccount(AccountModel account) {
        this.account = account;
    }
}
