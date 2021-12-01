package com.phexum.formHandler.domain.feature.quota;

import com.phexum.formHandler.domain.factory.config.Config;

public class QuotaFeatureImpl implements QuotaFeature {
    private final Config config;

    public QuotaFeatureImpl(Config config) {
        this.config = config;
    }

    public boolean checkQuota(Long formSubmitCount) {
        if (formSubmitCount < config.getQuota()) {
            return true;
        } else {
            return false;
        }

    }
}
