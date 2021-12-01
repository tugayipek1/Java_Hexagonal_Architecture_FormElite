package com.phexum.formelite.infralayer.journal.adapters.jpa.repository;

import com.phexum.formHandler.domain.journal.model.JournalModel;
import com.phexum.formHandler.domain.journal.port.JournalRepositoryPort;
import com.phexum.formelite.infralayer.common.Convertible;
import com.phexum.formelite.infralayer.journal.adapters.jpa.entity.JournalEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JournalJpaAdapter extends Convertible<JournalModel, JournalEntity> implements JournalRepositoryPort {

    private final JournalJpaRepository repository;

    public JournalJpaAdapter(JournalJpaRepository repository, ModelMapper mapper) {
        super(mapper,JournalModel.class, JournalEntity.class);
        this.repository = repository;
    }

    @Override
    public JournalModel create(JournalModel journalModel) {
        return entityToModel(repository.save(modelToEntity(journalModel)));
    }

    @Override
    public JournalModel update(JournalModel journalModel) {
        Optional<JournalModel> journalOp = getById(journalModel.getId());

        if (journalOp.isEmpty()) {
            return null;
        } else {
            return entityToModel(repository.save(modelToEntity(journalModel)));
        }
    }

    @Override
    public Optional<JournalModel> getById(Long id) {
        return repository.findById(id).map(x -> entityToModel(x));
    }

    @Override
    public List<JournalModel> getAll() {
        return repository.findAll().stream().map(x -> entityToModel(x)).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
