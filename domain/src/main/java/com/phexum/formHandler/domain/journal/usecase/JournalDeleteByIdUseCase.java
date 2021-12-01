package com.phexum.formHandler.domain.journal.usecase;

import com.phexum.formHandler.domain.common.usecase.UseCase;

public class JournalDeleteByIdUseCase implements UseCase {
    private Long id;

    public JournalDeleteByIdUseCase(){}

    public JournalDeleteByIdUseCase(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}



