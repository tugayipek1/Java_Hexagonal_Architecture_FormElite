package com.phexum.formHandler.domain.form.usecase;

import com.phexum.formHandler.domain.common.usecase.UseCase;

public class GetFormSubmitValueByFormUseCase implements UseCase {
    private long formId;

    public GetFormSubmitValueByFormUseCase() {
    }
    public GetFormSubmitValueByFormUseCase(long formId) {

        this.formId = formId;
    }

    public long getFormId() {
        return formId;
    }
}
