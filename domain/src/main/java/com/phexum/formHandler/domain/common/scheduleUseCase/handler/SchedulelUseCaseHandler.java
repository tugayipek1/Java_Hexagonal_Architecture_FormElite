package com.phexum.formHandler.domain.common.scheduleUseCase.handler;

import com.phexum.formHandler.domain.account.model.AccountModel;
import com.phexum.formHandler.domain.account.port.AccountRepositoryPort;
import com.phexum.formHandler.domain.bill.model.BillModel;
import com.phexum.formHandler.domain.bill.port.BillRepositoryPort;
import com.phexum.formHandler.domain.bill.service.BillService;
import com.phexum.formHandler.domain.bill.usecase.BillCreateUseCase;
import com.phexum.formHandler.domain.bill.usecase.handler.BillCreateUseCaseHandler;
import com.phexum.formHandler.domain.common.DomainComponent;
import com.phexum.formHandler.domain.common.helper.notification.port.NotificationSenderPort;
import com.phexum.formHandler.domain.common.scheduleUseCase.ScheduleUseCase;
import com.phexum.formHandler.domain.common.usecase.ObservableUseCaseHandler;
import com.phexum.formHandler.domain.common.usecase.VoidUseCaseHandler;
import com.phexum.formHandler.domain.form.port.FormSubmitRepositoryPort;
import com.phexum.formHandler.domain.journal.port.JournalRepositoryPort;
import com.phexum.formHandler.domain.journal.service.JournalService;
import com.phexum.formHandler.domain.journal.usecase.JournalCreateUseCase;
import com.phexum.formHandler.domain.journal.usecase.handler.JournalCreateUseCaseHandler;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@DomainComponent
public class SchedulelUseCaseHandler extends ObservableUseCaseHandler implements VoidUseCaseHandler<ScheduleUseCase> {
    private final BillRepositoryPort billRepository;
    private final AccountRepositoryPort accountRepository;
    private final JournalRepositoryPort journalRepository;
    private final NotificationSenderPort notificationSender;
    private final BillService billService;
    private final JournalService journalService;
    private final FormSubmitRepositoryPort formSubmitRepository;


    public SchedulelUseCaseHandler(BillRepositoryPort billRepository, AccountRepositoryPort accountRepository, JournalRepositoryPort journalRepository, NotificationSenderPort notificationSender, BillService billService, JournalService journalService, NotificationSenderPort notificationSenderPort, FormSubmitRepositoryPort formSubmitRepository) {
        this.billRepository = billRepository;
        this.accountRepository = accountRepository;
        this.journalRepository = journalRepository;
        this.notificationSender = notificationSender;
        this.billService = billService;
        this.journalService = journalService;
        this.formSubmitRepository = formSubmitRepository;
        register(ScheduleUseCase.class, this);
    }

    @Override
    public void handle(ScheduleUseCase usecase) {
        Date now = new Date();
        Date billDate = Date.from(now.toInstant().minusSeconds(60 * 60 * 24 * 30));

        List<BillModel> bills = billRepository.findByCreatedAt(billDate);
        List<AccountModel> accounts = bills.stream().map(x -> x.getAccount()).collect(Collectors.toList());

        accounts.addAll(accountRepository.findByCreatedAt(billDate));

        BillCreateUseCaseHandler billRegisterationUseCaseHandler = new BillCreateUseCaseHandler(billService, billRepository, notificationSender);
        accounts.stream().forEach(x -> billRegisterationUseCaseHandler.handle(new BillCreateUseCase(x)));

        JournalCreateUseCaseHandler journalRegisterationUseCaseHandler = new JournalCreateUseCaseHandler(journalRepository, formSubmitRepository, accountRepository, journalService, notificationSender);
        journalRegisterationUseCaseHandler.handle(new JournalCreateUseCase());
    }
}
