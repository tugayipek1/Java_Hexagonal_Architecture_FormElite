package com.phexum.formelite.infralayer.journal.adapters.jpa.repository;

import com.phexum.formelite.infralayer.journal.adapters.jpa.entity.JournalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalJpaRepository extends JpaRepository<JournalEntity, Long> {
}
