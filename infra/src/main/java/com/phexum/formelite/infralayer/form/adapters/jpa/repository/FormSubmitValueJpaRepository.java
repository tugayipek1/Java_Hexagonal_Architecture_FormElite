package com.phexum.formelite.infralayer.form.adapters.jpa.repository;

import com.phexum.formHandler.domain.form.model.FormSubmit;
import com.phexum.formHandler.domain.form.model.FormSubmitValue;
import com.phexum.formelite.infralayer.form.adapters.jpa.entity.FormSubmitEntity;
import com.phexum.formelite.infralayer.form.adapters.jpa.entity.FormSubmitValueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormSubmitValueJpaRepository extends JpaRepository<FormSubmitValueEntity, Long> {
    List<FormSubmitValueEntity> findByFormSubmit(FormSubmitEntity formSubmit);
}
