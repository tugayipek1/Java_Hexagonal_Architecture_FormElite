package com.phexum.formelite.infralayer.account.adapters.jpa.repository;

import com.phexum.formHandler.domain.account.model.AccountModel;
import com.phexum.formHandler.domain.account.model.AccountType;
import com.phexum.formelite.infralayer.account.adapters.jpa.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface AccountJpaRepository extends JpaRepository<AccountEntity, Long> {

    Optional<AccountEntity> findByEmail(String email);

    Optional<AccountEntity> findById(Long id);

    List<AccountEntity> findByCreatedAt(Date date);
    List<AccountEntity> findByAccountType(AccountType type);




}
