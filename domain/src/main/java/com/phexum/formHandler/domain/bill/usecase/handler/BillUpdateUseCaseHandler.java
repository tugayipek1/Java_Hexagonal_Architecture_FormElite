package com.phexum.formHandler.domain.bill.usecase.handler;

import com.phexum.formHandler.domain.bill.model.BillModel;
import com.phexum.formHandler.domain.bill.port.BillRepositoryPort;
import com.phexum.formHandler.domain.bill.service.BillService;
import com.phexum.formHandler.domain.bill.usecase.BillUpdateUseCase;
import com.phexum.formHandler.domain.common.DomainComponent;
import com.phexum.formHandler.domain.common.usecase.ObservableUseCaseHandler;
import com.phexum.formHandler.domain.common.usecase.UseCaseHandler;
@DomainComponent
public class BillUpdateUseCaseHandler extends ObservableUseCaseHandler implements UseCaseHandler<BillModel, BillUpdateUseCase> {

   private final BillService service;
   private final BillRepositoryPort repository;

    public BillUpdateUseCaseHandler(BillService service, BillRepositoryPort repository) {
        this.service = service;
        this.repository = repository;
        register(BillUpdateUseCase.class,this);
    }


    @Override
    public BillModel handle(BillUpdateUseCase usecase) {
        return repository.update(usecase.getBill());
    }
}
