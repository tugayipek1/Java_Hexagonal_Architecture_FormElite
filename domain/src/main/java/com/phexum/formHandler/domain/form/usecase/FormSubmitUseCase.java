package com.phexum.formHandler.domain.form.usecase;

import com.phexum.formHandler.domain.common.usecase.UseCase;
import com.phexum.formHandler.domain.form.model.FormSubmit;
import com.phexum.formHandler.domain.form.model.FormSubmitValue;

import java.util.HashMap;
import java.util.Map;

public class FormSubmitUseCase implements UseCase {
    private long formId;
    private Map<String, String> formSubmitValues ;
    private String ip;
    private String os;

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setFormSubmitValues() {
    }

    public String getIp() {
        return ip;
    }

    public String getOs() {
        return os;
    }

    public FormSubmitUseCase(long formId, Map<String, String> formSubmitValues, String ip, String os) {
        this.formId = formId;
        this.formSubmitValues = formSubmitValues;
        this.ip = ip;
        this.os = os;
    }

    public long getFormId() {
        return formId;
    }

    public void setFormId(long formId) {
        this.formId = formId;
    }

    public Map<String, String> getFormSubmitValues() {
        return formSubmitValues;
    }

    public void setFormSubmitValues(Map<String, String> formSubmitValues) {
        this.formSubmitValues = formSubmitValues;
    }
}

