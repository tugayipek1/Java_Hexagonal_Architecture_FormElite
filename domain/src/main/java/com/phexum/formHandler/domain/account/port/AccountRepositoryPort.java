package com.phexum.formHandler.domain.account.port;

import com.phexum.formHandler.domain.account.model.AccountModel;
import com.phexum.formHandler.domain.account.model.AccountType;
import com.phexum.formHandler.domain.common.BaseRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface AccountRepositoryPort extends BaseRepository<AccountModel, Long> {
    Optional<AccountModel> findByEmail(String email);

    Optional<AccountModel> findById(Long id);

    List<AccountModel> findByCreatedAt(Date date);

    void updateAll(List<AccountModel> accounts);

    List<AccountModel> findByAccountType(AccountType type);
}
