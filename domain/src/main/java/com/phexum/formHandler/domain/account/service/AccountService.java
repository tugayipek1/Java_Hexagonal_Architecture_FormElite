package com.phexum.formHandler.domain.account.service;

import com.phexum.formHandler.domain.account.model.AccountModel;
import com.phexum.formHandler.domain.common.BaseRepository;

public interface AccountService{
    boolean checkEmailExist(String email);
}
