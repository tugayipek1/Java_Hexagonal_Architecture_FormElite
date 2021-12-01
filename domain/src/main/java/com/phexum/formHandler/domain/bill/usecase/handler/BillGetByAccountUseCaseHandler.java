package com.phexum.formHandler.domain.bill.usecase.handler;

import com.phexum.formHandler.domain.bill.model.BillModel;
import com.phexum.formHandler.domain.bill.port.BillRepositoryPort;
import com.phexum.formHandler.domain.bill.usecase.BillGetByAccountUseCase;
import com.phexum.formHandler.domain.common.DomainComponent;
import com.phexum.formHandler.domain.common.usecase.ObservableUseCaseHandler;
import com.phexum.formHandler.domain.common.usecase.UseCaseHandler;

import java.util.List;
@DomainComponent
public class BillGetByAccountUseCaseHandler extends ObservableUseCaseHandler implements UseCaseHandler<List<BillModel>, BillGetByAccountUseCase> {

    private final BillRepositoryPort billRepository;

    public BillGetByAccountUseCaseHandler(BillRepositoryPort billRepository) {
        this.billRepository = billRepository;
        register(BillGetByAccountUseCase.class,this);
    }

    @Override
    public List<BillModel> handle(BillGetByAccountUseCase usecase) {
        return billRepository.getAllByAccount(usecase.getAccount());
    }
}
