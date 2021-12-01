package com.phexum.formelite.infralayer.bill.adapters.jpa.repository;

import com.phexum.formHandler.domain.account.model.AccountModel;
import com.phexum.formHandler.domain.bill.model.BillModel;
import com.phexum.formHandler.domain.bill.port.BillRepositoryPort;
import com.phexum.formelite.infralayer.account.adapters.jpa.entity.AccountEntity;
import com.phexum.formelite.infralayer.bill.adapters.jpa.entity.BillEntity;
import com.phexum.formelite.infralayer.common.Convertible;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BillJpaAdapter extends Convertible<BillModel, BillEntity> implements BillRepositoryPort {

    private final BillJpaRespository repository;

    public BillJpaAdapter(BillJpaRespository repository, ModelMapper mapper) {
        super(mapper, BillModel.class, BillEntity.class);
        this.repository = repository;
    }

    @Override
    public List<BillModel> getAllByAccount(AccountModel accountModel) {
        return repository.findByAccount(independentMapper(accountModel, AccountEntity.class))
                .stream().map(x->entityToModel(x)).collect(Collectors.toList());
    }

    @Override
    public List<BillModel> findByDueDate(Date date) {
        return repository.findByDueDate(date).stream().map(x->entityToModel(x)).collect(Collectors.toList());
    }

    @Override
    public List<BillModel> findByCreatedAt(Date date) {
        return repository.findByCreatedAt(date).stream().map(x->entityToModel(x)).collect(Collectors.toList());
    }

    @Override
    public BillModel create(BillModel billModel) {
        return entityToModel(repository.save(modelToEntity(billModel)));
    }

    @Override
    public BillModel update(BillModel billModel) {
        if (repository.findById(billModel.getId()).isEmpty()){
            return null;
        }else
        {
            return entityToModel(repository.save(modelToEntity(billModel)));
        }
    }

    @Override
    public Optional<BillModel> getById(Long id) {
        return repository.findById(id).map(x->entityToModel(x));
    }

    @Override
    public List<BillModel> getAll() {
        return repository.findAll().stream().map(x->entityToModel(x)).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
