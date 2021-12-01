package com.phexum.formHandler.domain.form.usecase;

import com.phexum.formHandler.domain.common.usecase.UseCase;
import com.phexum.formHandler.domain.form.model.FormModel;

public class FormCreateUseCase implements UseCase {
    private FormModel form;

    public FormCreateUseCase() {
    }
    public FormCreateUseCase(FormModel form) {
        this.form = form;
    }

    public FormModel getForm() {
        return form;
    }
}
