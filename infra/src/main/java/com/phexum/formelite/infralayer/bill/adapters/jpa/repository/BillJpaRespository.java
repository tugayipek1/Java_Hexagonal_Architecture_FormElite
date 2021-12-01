package com.phexum.formelite.infralayer.bill.adapters.jpa.repository;


import com.phexum.formelite.infralayer.account.adapters.jpa.entity.AccountEntity;
import com.phexum.formelite.infralayer.bill.adapters.jpa.entity.BillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BillJpaRespository extends JpaRepository<BillEntity,Long> {
    List<BillEntity> findByAccount(AccountEntity account);
    List<BillEntity> findByDueDate(Date date);
    List<BillEntity> findByCreatedAt(Date date);
}
