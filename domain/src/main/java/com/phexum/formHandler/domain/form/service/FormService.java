package com.phexum.formHandler.domain.form.service;

import com.phexum.formHandler.domain.common.BaseRepository;
import com.phexum.formHandler.domain.form.model.FormModel;


public interface FormService {
    boolean checkFormExistById(Long id);
}
