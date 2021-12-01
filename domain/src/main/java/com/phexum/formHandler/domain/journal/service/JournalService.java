package com.phexum.formHandler.domain.journal.service;

import com.phexum.formHandler.domain.account.model.AccountType;
import com.phexum.formHandler.domain.common.BaseRepository;
import com.phexum.formHandler.domain.journal.model.JournalModel;

import java.util.List;

public interface JournalService {
    List<AccountType> availableAccountTypes();
}
