package com.phexum.formelite.infralayer.form.adapters.jpa.repository;

import com.phexum.formelite.infralayer.account.adapters.jpa.entity.AccountEntity;
import com.phexum.formelite.infralayer.form.adapters.jpa.entity.FormEntity;
import com.phexum.formelite.infralayer.form.adapters.jpa.entity.FormSubmitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface FormSubmitJpaRepository extends JpaRepository<FormSubmitEntity,Long> {
    Long countByForm_Account(AccountEntity account);
    List<FormSubmitEntity> findByForm(FormEntity form);
    @Query("select count(0) from FormSubmitEntity f where f.submitDate >=:date and f.form.account = :account")
    Long countBySubmitDateAndFormAccount(@Param("date") Date date,@Param("account") AccountEntity account);
}
