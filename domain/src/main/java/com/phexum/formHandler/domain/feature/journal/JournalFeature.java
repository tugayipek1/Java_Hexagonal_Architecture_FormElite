package com.phexum.formHandler.domain.feature.journal;

import com.phexum.formHandler.domain.account.model.AccountModel;
import com.phexum.formHandler.domain.journal.model.CreateJournalFeatureDto;
import com.phexum.formHandler.domain.journal.model.JournalModel;

public interface JournalFeature {
    JournalModel createJournal(CreateJournalFeatureDto dto);
}
