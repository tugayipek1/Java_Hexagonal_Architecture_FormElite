package com.phexum.formHandler.domain.form.model;


import java.util.HashMap;
import java.util.Map;

public class FormGetResponseDto {
    private FormModel form;
    private Map<FormSubmit, FormSubmitValue> formSubmitValues;


    public FormGetResponseDto(FormModel form, Map<FormSubmit, FormSubmitValue> formSubmitValues) {
        this.form = form;
        this.formSubmitValues = formSubmitValues;
    }

    public FormModel getForm() {
        return form;
    }

    public Map<FormSubmit, FormSubmitValue> getFormSubmitValues() {
        return formSubmitValues;
    }
}
