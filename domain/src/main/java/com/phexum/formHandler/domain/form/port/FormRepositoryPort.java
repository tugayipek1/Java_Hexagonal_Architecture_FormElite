package com.phexum.formHandler.domain.form.port;

import com.phexum.formHandler.domain.account.model.AccountModel;
import com.phexum.formHandler.domain.common.BaseRepository;
import com.phexum.formHandler.domain.form.model.FormModel;

import java.util.List;

public interface FormRepositoryPort extends BaseRepository<FormModel,Long> {

    List<FormModel> getAllByAccount(AccountModel account);
}
