package com.phexum.formHandler.domain.bill.usecase.handler;

import com.phexum.formHandler.domain.bill.model.BillModel;
import com.phexum.formHandler.domain.bill.port.BillRepositoryPort;
import com.phexum.formHandler.domain.bill.service.BillService;
import com.phexum.formHandler.domain.bill.usecase.BillGetByIdUseCase;
import com.phexum.formHandler.domain.common.DomainComponent;
import com.phexum.formHandler.domain.common.exception.AccountNotFoundException;
import com.phexum.formHandler.domain.common.usecase.ObservableUseCaseHandler;
import com.phexum.formHandler.domain.common.usecase.UseCaseHandler;
@DomainComponent
public class BillGetByIdUseCaseHandler extends ObservableUseCaseHandler implements UseCaseHandler<BillModel, BillGetByIdUseCase> {

    private final BillService service;
    private final BillRepositoryPort repository;

    public BillGetByIdUseCaseHandler(BillService service, BillRepositoryPort repository) {
        this.service = service;
        this.repository = repository;
        register(BillGetByIdUseCase.class,this);
    }

    @Override
    public BillModel handle(BillGetByIdUseCase usecase) {
        return repository.getById(usecase.getId()).orElseThrow(() -> new AccountNotFoundException("Account not found"));
    }
}
