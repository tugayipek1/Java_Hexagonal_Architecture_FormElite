package com.phexum.formHandler.domain.form.model;

public class FormSubmitValue {
    private long id;
    private FormSubmit formSubmit;
    private String fieldName;
    private String fieldValue;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public FormSubmit getFormSubmit() {
        return formSubmit;
    }

    public void setFormSubmit(FormSubmit formSubmit) {
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
    public FormSubmitValue(){}

    public FormSubmitValue( String fieldName, String fieldValue,FormSubmit formSubmit ) {
        this.formSubmit = formSubmit;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
