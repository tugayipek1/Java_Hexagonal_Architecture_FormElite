package com.phexum.formHandler.domain.form.service;

import com.phexum.formHandler.domain.common.DomainComponent;
import com.phexum.formHandler.domain.form.model.FormModel;
import com.phexum.formHandler.domain.form.port.FormRepositoryPort;

import java.util.Optional;

@DomainComponent
public class FormServiceImpl implements FormService {

    private final FormRepositoryPort repository;

    public FormServiceImpl(FormRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public boolean checkFormExistById(Long id) {
        Optional<FormModel> op = repository.getById(id);
        if (op.isPresent()) {
            return true;
        }
        return false;
    }
}
