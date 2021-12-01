package com.phexum.formHandler.domain.form.usecase.handler;

import com.phexum.formHandler.domain.account.port.AccountRepositoryPort;
import com.phexum.formHandler.domain.common.DomainComponent;
import com.phexum.formHandler.domain.common.exception.FormNotFoundException;
import com.phexum.formHandler.domain.common.exception.QuotaOutOfBoundsException;
import com.phexum.formHandler.domain.common.helper.notification.model.NotificationContent;
import com.phexum.formHandler.domain.common.helper.notification.port.NotificationSenderPort;
import com.phexum.formHandler.domain.common.usecase.ObservableUseCaseHandler;
import com.phexum.formHandler.domain.common.usecase.VoidUseCaseHandler;
import com.phexum.formHandler.domain.feature.instantAlert.InstantAlertFeature;
import com.phexum.formHandler.domain.feature.instantAlert.InstantAlertBuilderFeature;
import com.phexum.formHandler.domain.feature.quota.QuotaFeature;
import com.phexum.formHandler.domain.feature.quota.QuotaFeatureBuilder;
import com.phexum.formHandler.domain.feature.spam.SpamFeature;
import com.phexum.formHandler.domain.feature.spam.SpamFeatureBuilder;
import com.phexum.formHandler.domain.form.model.FormModel;
import com.phexum.formHandler.domain.form.model.FormSubmit;
import com.phexum.formHandler.domain.form.model.FormSubmitValue;
import com.phexum.formHandler.domain.form.port.FormRepositoryPort;
import com.phexum.formHandler.domain.form.port.FormSubmitRepositoryPort;
import com.phexum.formHandler.domain.form.port.FormSubmitValueRepositoryPort;
import com.phexum.formHandler.domain.form.usecase.FormSubmitUseCase;

import java.util.Date;
@DomainComponent
public class FormSubmitUseCaseHandler extends ObservableUseCaseHandler implements VoidUseCaseHandler<FormSubmitUseCase> {


    private final AccountRepositoryPort accountRepository;
    private final FormRepositoryPort formRepository;
    private final FormSubmitRepositoryPort formSubmitRepository;
    private final FormSubmitValueRepositoryPort formSubmitValueRepository;
    private final NotificationSenderPort notificationSenderPort;

    public FormSubmitUseCaseHandler(AccountRepositoryPort accountRepository, FormRepositoryPort formRepository, FormSubmitRepositoryPort formSubmitRepository, FormSubmitValueRepositoryPort formSubmitValueRepository, NotificationSenderPort notificationSenderPort) {
        this.accountRepository = accountRepository;
        this.formRepository = formRepository;
        this.formSubmitRepository = formSubmitRepository;
        this.formSubmitValueRepository = formSubmitValueRepository;
        this.notificationSenderPort = notificationSenderPort;
        register(FormSubmitUseCase.class,this);
    }

    @Override
    public void handle(FormSubmitUseCase usecase) {

        FormModel form = formRepository.getById(usecase.getFormId())
                .orElseThrow(() -> new FormNotFoundException("Form not found"));

        QuotaFeature quota = new QuotaFeatureBuilder().accountType(form.getAccount().getAccountType()).build();

        SpamFeature spamFilter = new SpamFeatureBuilder().accountType(form.getAccount().getAccountType()).build();
        boolean isSpam = false;

        if (!quota.checkQuota(formSubmitRepository.countByAccount(form.getAccount()))) {
            throw new QuotaOutOfBoundsException("Quouta is full");
        }

        for (String value : usecase.getFormSubmitValues().values()) {
            isSpam = spamFilter.detectSpam(value);
        }
        if (!isSpam) {

            FormSubmit formSubmit = new FormSubmit();
            formSubmit.setForm(form);
            formSubmit.setSubmitDate(new Date());
            formSubmit.setIp(usecase.getIp());
            formSubmit.setOs(usecase.getOs());

            FormSubmit formSubmitRecord = formSubmitRepository.create(formSubmit);

            usecase.getFormSubmitValues()
                    .entrySet().stream()
                    .map(x -> new FormSubmitValue(x.getKey(), x.getValue(), formSubmitRecord))
                    .forEach(formSubmitValueRepository::create);


            InstantAlertFeature instantAlertFeature = new InstantAlertBuilderFeature()
                    .accountType(form.getAccount().getAccountType())
                    .notificationSender(notificationSenderPort)
                    .build();

            NotificationContent notificationContent = new NotificationContent(form.getAccount(),
                    "info@formelite.com", "Biri form doldurdu");
            instantAlertFeature.instantAlert(notificationContent);


        }
    }
}
