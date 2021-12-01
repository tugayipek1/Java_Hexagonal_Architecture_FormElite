package com.phexum.formelite.infralayer.form.adapters.jpa.entity;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class FormSubmitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @OnDelete(action= OnDeleteAction.CASCADE)
    private FormEntity form;
    private String ip;
    private String os;
    private Date submitDate;
    //@OneToMany (orphanRemoval = true, cascade = CascadeType.REMOVE, mappedBy = "formSubmit")
   //private List<FormSubmitValueEntity> formSubmitValueEntities;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public FormEntity getForm() {
        return form;
    }

    public void setForm(FormEntity form) {
        this.form = form;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }
}
