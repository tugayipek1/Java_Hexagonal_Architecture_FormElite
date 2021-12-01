package com.phexum.formelite.infralayer.account.adapters.jpa.repository;

import com.phexum.formHandler.domain.account.model.AccountModel;
import com.phexum.formHandler.domain.account.model.AccountType;
import com.phexum.formHandler.domain.account.port.AccountRepositoryPort;
import com.phexum.formelite.infralayer.account.adapters.jpa.entity.AccountEntity;
import com.phexum.formelite.infralayer.common.Convertible;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountJpaAdapter extends Convertible<AccountModel, AccountEntity> implements AccountRepositoryPort {

private final AccountJpaRepository repository;

    public AccountJpaAdapter(AccountJpaRepository repository, ModelMapper mapper) {
        super(mapper, AccountModel.class, AccountEntity.class);
        this.repository = repository;
    }

    @Override
    public Optional<AccountModel> findByEmail(String email) {

        return repository.findByEmail(email).map(x->entityToModel(x));
    }
    @Override
    public Optional<AccountModel> findById(Long id) {
        return repository.findById(id).map(x -> entityToModel(x));
    }

    @Override
    public List<AccountModel> findByCreatedAt(Date date) {
        return repository.findByCreatedAt(date).stream()
                .map(x->entityToModel(x))
                .collect(Collectors.toList());
    }

    @Override
    public void updateAll(List<AccountModel> list) {
        throw new RuntimeException("updateAll çalıştı");
    //    repository.updateAll(list);

    }

    @Override
    public List<AccountModel> findByAccountType(AccountType accountType) {
        return repository.findByAccountType(accountType).stream()
                .map(x->entityToModel(x))
                .collect(Collectors.toList());
    }


    @Override
    public AccountModel create(AccountModel accountModel) {
        return entityToModel(repository.save(modelToEntity(accountModel)));
    }

    @Override
    public AccountModel update(AccountModel accountModel) {
        if (repository.findById(accountModel.getId()).isPresent()) {
            return create(accountModel);
        } else {
            return null;
        }
    }

    @Override
    public Optional<AccountModel> getById(Long id) {
        return repository.findById(id).map(x->entityToModel(x));

    }

    @Override
    public List<AccountModel> getAll() {
        return repository.findAll().stream().map(x -> entityToModel(x)).collect(Collectors.toList());

    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);


    }
}
