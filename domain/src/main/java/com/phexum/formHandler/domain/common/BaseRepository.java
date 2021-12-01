package com.phexum.formHandler.domain.common;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<T, ID> {
    T create(T entity);

    T update(T entity);

    Optional<T> getById(ID id);

    List<T> getAll();

    void deleteById(ID id);
}
