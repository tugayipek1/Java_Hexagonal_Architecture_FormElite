package com.phexum.formHandler.domain.account.usecase.handler;

import com.phexum.formHandler.domain.account.model.AccountModel;
import com.phexum.formHandler.domain.account.port.AccountRepositoryPort;
import com.phexum.formHandler.domain.account.service.AccountService;
import com.phexum.formHandler.domain.account.usecase.AccountRegisterationUseCase;
import com.phexum.formHandler.domain.bill.port.BillRepositoryPort;
import com.phexum.formHandler.domain.bill.service.BillService;
import com.phexum.formHandler.domain.bill.usecase.BillCreateUseCase;
import com.phexum.formHandler.domain.bill.usecase.handler.BillCreateUseCaseHandler;
import com.phexum.formHandler.domain.common.DomainComponent;
import com.phexum.formHandler.domain.common.exception.AccountNotFoundException;
import com.phexum.formHandler.domain.common.helper.notification.port.NotificationSenderPort;
import com.phexum.formHandler.domain.common.usecase.ObservableUseCaseHandler;
import com.phexum.formHandler.domain.common.usecase.UseCaseHandler;

import java.util.Date;

@DomainComponent
public class AccountRegisterationUseCaseHandler extends ObservableUseCaseHandler implements UseCaseHandler<AccountModel, AccountRegisterationUseCase> {

    private final AccountRepositoryPort accountRepository;
    private final AccountService accountService;
    private final BillService billService;
    private final BillRepositoryPort billRepository;
    private final NotificationSenderPort notificationSenderPort;


    public AccountRegisterationUseCaseHandler(AccountRepositoryPort accountRepository, AccountService accountService, BillService billService, BillRepositoryPort billRepository, NotificationSenderPort notificationSenderPort) {
        this.accountRepository = accountRepository;
        this.accountService = accountService;
        this.billService = billService;
        this.billRepository = billRepository;
        this.notificationSenderPort = notificationSenderPort;
        register(AccountRegisterationUseCase.class, this);
    }

    @Override
    public AccountModel handle(AccountRegisterationUseCase usecase) {
        if (accountService.checkEmailExist(usecase.getAccount().getEmail())) {
            throw new AccountNotFoundException("Account already exist");
        }
        usecase.getAccount().setCreatedAt(new Date());
        AccountModel account = accountRepository.create(usecase.getAccount());

        BillCreateUseCaseHandler billRegisterationUseCaseHandler = new BillCreateUseCaseHandler(billService, billRepository, notificationSenderPort);
        billRegisterationUseCaseHandler.handle(new BillCreateUseCase(account));
        return account;
    }
}
