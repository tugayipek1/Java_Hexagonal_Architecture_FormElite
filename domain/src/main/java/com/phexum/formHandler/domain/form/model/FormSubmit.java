package com.phexum.formHandler.domain.form.model;

import java.util.Date;

public class FormSubmit {
    private long id;
    private FormModel form;
    private String ip;
    private String os;
    private Date submitDate;

    public FormModel getForm() {
        return form;
    }

    public void setForm(FormModel form) {
        this.form = form;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }


    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }
}
