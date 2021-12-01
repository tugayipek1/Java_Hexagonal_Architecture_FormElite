package com.phexum.formHandler.domain.form.port;

import com.phexum.formHandler.domain.account.model.AccountModel;
import com.phexum.formHandler.domain.common.BaseRepository;
import com.phexum.formHandler.domain.form.model.FormModel;
import com.phexum.formHandler.domain.form.model.FormSubmit;

import java.util.Date;
import java.util.List;

public interface FormSubmitRepositoryPort extends BaseRepository<FormSubmit, Long> {
    Long countByAccount(AccountModel accountModel);
    List<FormSubmit> getByForm(FormModel form);
    Long countBySubmitDateAndFormAccount(Date Date,AccountModel account);
}
