package com.phexum.formHandler.domain.form.usecase;

import com.phexum.formHandler.domain.common.usecase.UseCase;
import com.phexum.formHandler.domain.form.model.FormModel;

public class FormGetByIdUseCase implements UseCase {
    private Long id;

    public FormGetByIdUseCase() {

    }
    public FormGetByIdUseCase(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    }

