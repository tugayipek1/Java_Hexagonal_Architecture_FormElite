package com.phexum.formelite.infralayer.form.adapters.jpa.repository;

import com.phexum.formHandler.domain.account.model.AccountModel;
import com.phexum.formHandler.domain.form.model.FormModel;
import com.phexum.formHandler.domain.form.model.FormSubmit;
import com.phexum.formHandler.domain.form.port.FormSubmitRepositoryPort;
import com.phexum.formelite.infralayer.account.adapters.jpa.entity.AccountEntity;
import com.phexum.formelite.infralayer.common.Convertible;
import com.phexum.formelite.infralayer.form.adapters.jpa.entity.FormEntity;
import com.phexum.formelite.infralayer.form.adapters.jpa.entity.FormSubmitEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FormSubmitJpaAdapter extends Convertible<FormSubmit, FormSubmitEntity> implements FormSubmitRepositoryPort {
    private final FormSubmitJpaRepository formSubmitJpaRepository;

    public FormSubmitJpaAdapter(ModelMapper mapper, FormSubmitJpaRepository formSubmitJpaRepository) {
        super(mapper, FormSubmit.class, FormSubmitEntity.class);

        this.formSubmitJpaRepository = formSubmitJpaRepository;
    }

    @Override
    public Long countByAccount(AccountModel accountModel) {
        return formSubmitJpaRepository.countByForm_Account(independentMapper(accountModel, AccountEntity.class));
    }

    @Override
    public List<FormSubmit> getByForm(FormModel formModel) {
        List y=formSubmitJpaRepository.findByForm(independentMapper(formModel, FormEntity.class));
        return formSubmitJpaRepository.findByForm(independentMapper(formModel, FormEntity.class))
                .stream()
                .map(x -> entityToModel(x))
                .collect(Collectors.toList());
    }

    @Override
    public Long countBySubmitDateAndFormAccount(Date date, AccountModel accountModel) {
        return formSubmitJpaRepository.countBySubmitDateAndFormAccount(date,independentMapper(accountModel,AccountEntity.class));
    }

    @Override
    public FormSubmit create(FormSubmit formSubmit) {
        return entityToModel(formSubmitJpaRepository.save(modelToEntity(formSubmit)));
    }

    @Override
    public FormSubmit update(FormSubmit formSubmit) {
        if (formSubmitJpaRepository.findById(formSubmit.getId()).isEmpty()) {
            return null;
        }
        return entityToModel(formSubmitJpaRepository.save(modelToEntity(formSubmit)));
    }

    @Override
    public Optional<FormSubmit> getById(Long id) {
        return formSubmitJpaRepository.findById(id).map(x -> entityToModel(x));
    }

    @Override
    public List<FormSubmit> getAll() {
        return formSubmitJpaRepository.findAll()
                .stream()
                .map(x -> entityToModel(x))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        formSubmitJpaRepository.deleteById(id);
    }
}
