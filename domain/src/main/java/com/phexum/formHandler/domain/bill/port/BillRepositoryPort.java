package com.phexum.formHandler.domain.bill.port;

import com.phexum.formHandler.domain.account.model.AccountModel;
import com.phexum.formHandler.domain.bill.model.BillModel;
import com.phexum.formHandler.domain.common.BaseRepository;

import java.util.Date;
import java.util.List;

public interface BillRepositoryPort extends BaseRepository<BillModel, Long> {
    List<BillModel> getAllByAccount(AccountModel account);
    List<BillModel> findByDueDate(Date date);
    List<BillModel> findByCreatedAt(Date date);
}
