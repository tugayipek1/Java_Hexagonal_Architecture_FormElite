package com.phexum.formHandler.domain.journal.usecase.handler;

import com.phexum.formHandler.domain.account.model.AccountModel;
import com.phexum.formHandler.domain.account.model.AccountType;
import com.phexum.formHandler.domain.account.port.AccountRepositoryPort;
import com.phexum.formHandler.domain.common.DomainComponent;
import com.phexum.formHandler.domain.common.helper.notification.model.NotificationContent;
import com.phexum.formHandler.domain.common.helper.notification.port.NotificationSenderPort;
import com.phexum.formHandler.domain.common.usecase.ObservableUseCaseHandler;
import com.phexum.formHandler.domain.common.usecase.VoidUseCaseHandler;
import com.phexum.formHandler.domain.feature.journal.JournalFeature;
import com.phexum.formHandler.domain.feature.journal.JournalFeatureBuilder;
import com.phexum.formHandler.domain.form.port.FormSubmitRepositoryPort;
import com.phexum.formHandler.domain.journal.model.CreateJournalFeatureDto;
import com.phexum.formHandler.domain.journal.model.JournalModel;
import com.phexum.formHandler.domain.journal.port.JournalRepositoryPort;
import com.phexum.formHandler.domain.journal.service.JournalService;
import com.phexum.formHandler.domain.journal.usecase.JournalCreateUseCase;

import java.util.Date;
import java.util.List;

@DomainComponent
public class JournalCreateUseCaseHandler extends ObservableUseCaseHandler implements VoidUseCaseHandler<JournalCreateUseCase> {

    private final JournalRepositoryPort journalRepository;
    private final AccountRepositoryPort accountRepository;
    private final JournalService journalService;
    private final FormSubmitRepositoryPort formSubmitRepository;
    private final NotificationSenderPort notificationSender;


    public JournalCreateUseCaseHandler(JournalRepositoryPort journalRepository, FormSubmitRepositoryPort formSubmitRepository, AccountRepositoryPort accountRepository, JournalService journalService, NotificationSenderPort notificationSender) {
        this.journalRepository = journalRepository;
        this.accountRepository = accountRepository;
        this.journalService = journalService;
        this.formSubmitRepository = formSubmitRepository;
        this.notificationSender = notificationSender;


        register(JournalCreateUseCase.class, this);
    }

    @Override
    public void handle(JournalCreateUseCase usecase) {
        List<AccountType> accountTypes = journalService.availableAccountTypes();
        JournalFeature journalFeature = new JournalFeatureBuilder().build();

        accountTypes.stream().map(accountRepository::findByAccountType)
                .forEach(account -> createJournal(account, journalFeature));
    }

    public void createJournal(List<AccountModel> accounts, JournalFeature journalFeature) {

        accounts.forEach(account -> {
            try {
                Date now=new Date();
                Date journalDate = Date.from(now.toInstant().minusSeconds(60 * 60 * 24 * 1));
                Long submitCounts = formSubmitRepository.countBySubmitDateAndFormAccount(journalDate, account);
                JournalModel journal = journalFeature.createJournal(new CreateJournalFeatureDto(account, submitCounts));
                notificationSender.sendNotification(new NotificationContent(account, "Journal", journal.toString()));
                journalRepository.create(journal);
            } catch (RuntimeException e) {
                e.printStackTrace();
            }

        });

    }

}
