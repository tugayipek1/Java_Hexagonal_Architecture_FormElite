package com.phexum.formHandler.domain.journal.usecase;

import com.phexum.formHandler.domain.common.usecase.UseCase;
import com.phexum.formHandler.domain.journal.model.JournalModel;

public class JournalCreateUseCase implements UseCase {
    private JournalModel journal;
    public JournalCreateUseCase() {

    }
    public JournalCreateUseCase(JournalModel journal) {
        this.journal = journal;
    }

    public JournalModel getJournal() {
        return journal;
    }
}
