package com.phexum.formelite.infralayer.form.adapters.jpa.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
public class FormSubmitValueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @OnDelete(action= OnDeleteAction.CASCADE)
    private FormSubmitEntity formSubmit;
    private String fieldName;
    private String fieldValue;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public FormSubmitEntity getFormSubmit() {
        return formSubmit;
    }

    public void setFormSubmit(FormSubmitEntity formSubmit) {
        this.formSubmit = formSubmit;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }
}
