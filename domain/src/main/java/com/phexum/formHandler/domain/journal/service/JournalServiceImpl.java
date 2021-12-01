package com.phexum.formHandler.domain.journal.service;

import  com.phexum.formHandler.domain.account.model.AccountType;
import static com.phexum.formHandler.domain.account.model.AccountType.*;

import com.phexum.formHandler.domain.common.DomainComponent;
import com.phexum.formHandler.domain.factory.config.Config;
import com.phexum.formHandler.domain.factory.config.ConfigFactoryUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@DomainComponent
public class JournalServiceImpl implements JournalService {

    @Override
    public List<AccountType> availableAccountTypes() {
      return  List.of(FREE,PRO,ULTIMATE).stream()

              .filter(x->ConfigFactoryUtil.getFeatureConfig(x).getJournal())
              .collect(Collectors.toList());


    }
}