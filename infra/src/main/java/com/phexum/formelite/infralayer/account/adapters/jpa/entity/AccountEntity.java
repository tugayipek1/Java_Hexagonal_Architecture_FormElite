package com.phexum.formelite.infralayer.account.adapters.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.phexum.formHandler.domain.account.model.AccountType;
import com.phexum.formelite.infralayer.bill.adapters.jpa.entity.BillEntity;
import com.phexum.formelite.infralayer.form.adapters.jpa.entity.FormSubmitValueEntity;
import com.phexum.formelite.infralayer.journal.adapters.jpa.entity.JournalEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private Date createdAt;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @OneToMany ( cascade = CascadeType.REMOVE, mappedBy = "account")
    private List<JournalEntity> journal;
    @OneToMany ( cascade = CascadeType.REMOVE, mappedBy = "account")
    private List<BillEntity> bill;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

}
