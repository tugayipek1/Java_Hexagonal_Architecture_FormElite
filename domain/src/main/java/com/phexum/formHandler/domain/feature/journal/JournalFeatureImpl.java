package com.phexum.formHandler.domain.feature.journal;

import com.phexum.formHandler.domain.journal.model.CreateJournalFeatureDto;
import com.phexum.formHandler.domain.journal.model.JournalModel;

import java.util.Date;

public class JournalFeatureImpl implements JournalFeature {


    @Override
    public JournalModel createJournal(CreateJournalFeatureDto dto) {
        JournalModel journal = new JournalModel();
        Date date = new Date();
        journal.setName(date + " Bülteni ");
        journal.setFormCount(dto.getFormSubmitCounts());
        journal.setAccount(dto.getAccount());
        journal.setCreateDate(date);
        return journal;
    }

}
