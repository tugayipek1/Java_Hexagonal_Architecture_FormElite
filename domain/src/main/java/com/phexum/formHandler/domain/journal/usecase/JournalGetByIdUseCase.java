package com.phexum.formHandler.domain.journal.usecase;

import com.phexum.formHandler.domain.common.usecase.UseCase;
import com.phexum.formHandler.domain.journal.model.JournalModel;

public class JournalGetByIdUseCase implements UseCase {
    private Long id;

    public JournalGetByIdUseCase() {
    }
    public JournalGetByIdUseCase(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


}
