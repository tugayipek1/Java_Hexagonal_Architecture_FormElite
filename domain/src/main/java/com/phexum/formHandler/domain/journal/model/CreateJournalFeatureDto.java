package com.phexum.formHandler.domain.journal.model;

import com.phexum.formHandler.domain.account.model.AccountModel;

public class CreateJournalFeatureDto {

    private AccountModel account;
    private Long formSubmitCounts;

    public CreateJournalFeatureDto() {
    }

    public CreateJournalFeatureDto(AccountModel account, Long formSubmitCounts) {
        this.account = account;
        this.formSubmitCounts = formSubmitCounts;
    }

    public AccountModel getAccount() {
        return account;
    }

    public Long getFormSubmitCounts() {
        return formSubmitCounts;
    }

}
