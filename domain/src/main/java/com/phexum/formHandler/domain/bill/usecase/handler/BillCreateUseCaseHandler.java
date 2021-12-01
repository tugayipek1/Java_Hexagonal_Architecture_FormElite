package com.phexum.formHandler.domain.bill.usecase.handler;

import com.phexum.formHandler.domain.bill.model.BillModel;
import com.phexum.formHandler.domain.bill.port.BillRepositoryPort;
import com.phexum.formHandler.domain.bill.service.BillService;
import com.phexum.formHandler.domain.bill.usecase.BillCreateUseCase;
import com.phexum.formHandler.domain.common.DomainComponent;
import com.phexum.formHandler.domain.common.helper.notification.model.NotificationContent;
import com.phexum.formHandler.domain.common.helper.notification.port.NotificationSenderPort;
import com.phexum.formHandler.domain.common.usecase.ObservableUseCaseHandler;
import com.phexum.formHandler.domain.common.usecase.UseCaseHandler;
import com.phexum.formHandler.domain.feature.bill.BillFeature;
import com.phexum.formHandler.domain.feature.bill.BillFeatureBuilder;

@DomainComponent
public class BillCreateUseCaseHandler extends ObservableUseCaseHandler implements UseCaseHandler<BillModel, BillCreateUseCase> {

    private final BillService service;
    private final BillRepositoryPort repository;
    private final NotificationSenderPort notificationSenderPort;

    public BillCreateUseCaseHandler(BillService service, BillRepositoryPort repository, NotificationSenderPort notificationSenderPort) {
        this.service = service;
        this.repository = repository;
        this.notificationSenderPort = notificationSenderPort;
        register(BillCreateUseCase.class, this);
    }

    @Override
    public BillModel handle(BillCreateUseCase usecase) {

        BillFeature bill = new BillFeatureBuilder().accountType(usecase.getAccount().getAccountType()).notificationSender(notificationSenderPort).build();
        BillModel billMoldel = repository.create(bill.createBill(usecase.getAccount()));
        notificationSenderPort.sendNotification(new NotificationContent(usecase.getAccount(), "Fatura", billMoldel.toString()));

        return billMoldel;
    }

}
