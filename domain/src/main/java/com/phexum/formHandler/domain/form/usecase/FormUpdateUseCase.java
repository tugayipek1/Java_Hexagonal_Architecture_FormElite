package com.phexum.formHandler.domain.form.usecase;

import com.phexum.formHandler.domain.common.usecase.UseCase;
import com.phexum.formHandler.domain.form.model.FormModel;

public class FormUpdateUseCase implements UseCase {
    private FormModel form;

    public FormUpdateUseCase() {
    }
    public FormUpdateUseCase(FormModel form) {
        this.form = form;
    }

    public FormModel getForm() {
        return form;
    }
}
