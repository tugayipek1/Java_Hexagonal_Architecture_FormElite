package com.phexum.formelite.infralayer.form.adapters.jpa.repository;

import com.phexum.formHandler.domain.form.model.FormSubmit;
import com.phexum.formHandler.domain.form.model.FormSubmitValue;
import com.phexum.formHandler.domain.form.port.FormSubmitValueRepositoryPort;
import com.phexum.formelite.infralayer.common.Convertible;
import com.phexum.formelite.infralayer.form.adapters.jpa.entity.FormSubmitEntity;
import com.phexum.formelite.infralayer.form.adapters.jpa.entity.FormSubmitValueEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FormSubmitValueJpaAdapter extends Convertible<FormSubmitValue, FormSubmitValueEntity> implements FormSubmitValueRepositoryPort {
    private final FormSubmitValueJpaRepository formSubmitValueJpaRepository;

    public FormSubmitValueJpaAdapter(FormSubmitValueJpaRepository formSubmitValueJpaRepository, ModelMapper mapper) {
        super(mapper, FormSubmitValue.class, FormSubmitValueEntity.class);
        this.formSubmitValueJpaRepository = formSubmitValueJpaRepository;
    }

    @Override
    public FormSubmitValue create(FormSubmitValue formSubmitValue) {
        return entityToModel(formSubmitValueJpaRepository.save(modelToEntity(formSubmitValue)));
    }

    @Override
    public FormSubmitValue update(FormSubmitValue formSubmitValue) {
        if (formSubmitValueJpaRepository.findById(formSubmitValue.getId()).isEmpty()) {
            return null;
        }
        return entityToModel(formSubmitValueJpaRepository.save(modelToEntity(formSubmitValue)));
    }

    @Override
    public Optional<FormSubmitValue> getById(Long id) {
        return formSubmitValueJpaRepository.findById(id).map(x -> entityToModel(x));
    }

    @Override
    public List<FormSubmitValue> getAll() {

        return formSubmitValueJpaRepository.findAll().stream().map(x -> entityToModel(x)).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        formSubmitValueJpaRepository.deleteById(id);
    }

    @Override
    public List<FormSubmitValue> getByFormSubmit(FormSubmit formSubmit) {
        return formSubmitValueJpaRepository.findByFormSubmit(independentMapper(formSubmit, FormSubmitEntity.class)).stream().map(x->entityToModel(x)).collect(Collectors.toList());
    }
}
