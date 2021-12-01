package com.phexum.formelite.infralayer.form.adapters.jpa.entity;

import com.phexum.formelite.infralayer.account.adapters.jpa.entity.AccountEntity;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
public class FormEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @ManyToOne
    @OnDelete(action= OnDeleteAction.CASCADE)
    private AccountEntity account;
    //@OneToMany (orphanRemoval = true, cascade = CascadeType.REMOVE, mappedBy = "form")
    //private List<FormSubmitEntity> formSubmitEntities;

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

}
