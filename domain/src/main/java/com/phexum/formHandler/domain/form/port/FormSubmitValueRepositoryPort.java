package com.phexum.formHandler.domain.form.port;

import com.phexum.formHandler.domain.common.BaseRepository;
import com.phexum.formHandler.domain.form.model.FormSubmit;
import com.phexum.formHandler.domain.form.model.FormSubmitValue;

import java.util.List;

public interface FormSubmitValueRepositoryPort extends BaseRepository<FormSubmitValue, Long> {
    List<FormSubmitValue> getByFormSubmit(FormSubmit formsubmit);
}
