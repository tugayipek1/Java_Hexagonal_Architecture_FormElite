package com.phexum.formelite.infralayer.form.adapters.jpa.repository;

import com.phexum.formHandler.domain.account.model.AccountModel;
import com.phexum.formHandler.domain.form.model.FormModel;
import com.phexum.formHandler.domain.form.port.FormRepositoryPort;
import com.phexum.formelite.infralayer.account.adapters.jpa.entity.AccountEntity;
import com.phexum.formelite.infralayer.common.Convertible;
import com.phexum.formelite.infralayer.form.adapters.jpa.entity.FormEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FormJpaAdapter extends Convertible<FormModel, FormEntity> implements FormRepositoryPort {

    private final FormJpaRepository formJpaRepository;

    public FormJpaAdapter(FormJpaRepository formJpaRepository, ModelMapper mapper) {
        super(mapper, FormModel.class, FormEntity.class);
        this.formJpaRepository = formJpaRepository;
    }

    @Override
    public List<FormModel> getAllByAccount(AccountModel accountModel) {
        return formJpaRepository.findByAccount(independentMapper(accountModel, AccountEntity.class))
                .stream()
                .map(x -> entityToModel(x))
                .collect(Collectors.toList());
    }

    @Override
    public FormModel create(FormModel formModel) {
        return entityToModel(formJpaRepository.save(modelToEntity(formModel)));
    }

    @Override
    public FormModel update(FormModel formModel) {
        if (formJpaRepository.findById(formModel.getId()).isEmpty()) {
            return null;
        }
        return entityToModel(formJpaRepository.save(modelToEntity(formModel)));
    }

    @Override
    public Optional<FormModel> getById(Long id) {
        return formJpaRepository.findById(id).map(x -> entityToModel(x));
    }

    @Override
    public List<FormModel> getAll() {
        return formJpaRepository.findAll()
                .stream()
                .map(x -> entityToModel(x))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        formJpaRepository.deleteById(id);
    }
}
