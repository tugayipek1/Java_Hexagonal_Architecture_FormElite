package com.phexum.formelite.infralayer.form.adapters.jpa.repository;

import com.phexum.formelite.infralayer.account.adapters.jpa.entity.AccountEntity;
import com.phexum.formelite.infralayer.form.adapters.jpa.entity.FormEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormJpaRepository extends JpaRepository<FormEntity,Long> {
    List<FormEntity> findByAccount(AccountEntity account);
}
