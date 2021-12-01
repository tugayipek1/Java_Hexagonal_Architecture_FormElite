package com.phexum.formHandler.domain.journal.usecase;

import com.phexum.formHandler.domain.common.usecase.UseCase;
import com.phexum.formHandler.domain.journal.model.JournalModel;

public class JournalUpdateUseCase implements UseCase {
    private JournalModel journal;
    public JournalUpdateUseCase() {
    }
    public JournalUpdateUseCase(JournalModel journal) {
        this.journal = journal;
    }

    public JournalModel getJournal() {
        return journal;
    }
}
