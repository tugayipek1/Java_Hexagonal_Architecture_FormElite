package com.phexum.formHandler.domain.bill.usecase.handler;

import com.phexum.formHandler.domain.bill.model.BillModel;
import com.phexum.formHandler.domain.bill.port.BillRepositoryPort;
import com.phexum.formHandler.domain.bill.service.BillService;
import com.phexum.formHandler.domain.bill.usecase.BillDeleteByIdUseCase;
import com.phexum.formHandler.domain.common.DomainComponent;
import com.phexum.formHandler.domain.common.exception.BillNotFoundException;
import com.phexum.formHandler.domain.common.exception.FormNotFoundException;
import com.phexum.formHandler.domain.common.usecase.ObservableUseCaseHandler;
import com.phexum.formHandler.domain.common.usecase.VoidUseCaseHandler;
import com.phexum.formHandler.domain.form.model.FormModel;

@DomainComponent
public class BillDeleteByIdUseCaseHandler extends ObservableUseCaseHandler implements VoidUseCaseHandler<BillDeleteByIdUseCase> {

    private final BillService service;
    private final BillRepositoryPort repository;

    public BillDeleteByIdUseCaseHandler(BillService service, BillRepositoryPort repository) {
        this.service = service;
        this.repository = repository;
        register(BillDeleteByIdUseCase.class,this);
    }

    @Override
    public void handle(BillDeleteByIdUseCase usecase) {
        BillModel bill=repository.getById(usecase.getId()).orElseThrow(()->new FormNotFoundException("Bill not exist"));
        repository.deleteById(usecase.getId());
    }
}
