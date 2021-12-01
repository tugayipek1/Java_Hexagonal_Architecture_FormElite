package com.phexum.formHandler.domain.bill.usecase.handler;

import com.phexum.formHandler.domain.bill.model.BillModel;
import com.phexum.formHandler.domain.bill.port.BillRepositoryPort;
import com.phexum.formHandler.domain.bill.service.BillService;
import com.phexum.formHandler.domain.bill.usecase.BillGetAllUseCase;
import com.phexum.formHandler.domain.common.DomainComponent;
import com.phexum.formHandler.domain.common.usecase.ObservableUseCaseHandler;
import com.phexum.formHandler.domain.common.usecase.UseCaseHandler;

import java.util.List;
@DomainComponent
public class BillGetAllUseCaseHandler extends ObservableUseCaseHandler implements UseCaseHandler<List<BillModel>, BillGetAllUseCase> {
    private final BillService service;
    private final BillRepositoryPort repository;

    public BillGetAllUseCaseHandler(BillService service, BillRepositoryPort repository) {
        this.service = service;
        this.repository = repository;
        register(BillGetAllUseCase.class,this);
    }

    @Override
    public List<BillModel> handle(BillGetAllUseCase usecase) {
        return repository.getAll();
    }


}
