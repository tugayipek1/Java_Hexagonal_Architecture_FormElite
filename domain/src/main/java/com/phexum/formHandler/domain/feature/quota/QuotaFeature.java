package com.phexum.formHandler.domain.feature.quota;

import com.phexum.formHandler.domain.factory.config.Config;

public interface QuotaFeature {
    boolean checkQuota(Long formSubmitCount);
}
