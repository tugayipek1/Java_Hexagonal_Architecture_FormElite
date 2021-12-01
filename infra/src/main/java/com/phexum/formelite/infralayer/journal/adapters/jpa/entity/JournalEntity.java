package com.phexum.formelite.infralayer.journal.adapters.jpa.entity;

import com.phexum.formelite.infralayer.account.adapters.jpa.entity.AccountEntity;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
public class JournalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @ManyToOne
    @OnDelete(action= OnDeleteAction.CASCADE)
    private AccountEntity account;
    private Date createDate;
    private long formCount;

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

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
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
}
