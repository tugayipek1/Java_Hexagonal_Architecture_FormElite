package com.phexum.formHandler.domain.factory.config;

import com.phexum.formHandler.domain.account.model.AccountType;


import java.util.HashMap;
import java.util.Map;

public class ConfigFactoryUtil {
    private static final Map<AccountType, Config> configMap = new HashMap<>();
    private static final Config freeConfig = new FreeConfig();
    private static final Config proConfig = new ProConfig();
    private static final Config ultimateConfig = new UltimateConfig();

    private ConfigFactoryUtil() {
    }

    static {
        configMap.put(AccountType.FREE, freeConfig);
        configMap.put(AccountType.PRO, proConfig);
        configMap.put(AccountType.ULTIMATE, ultimateConfig);

    }

    public static Config getFeatureConfig(AccountType type) {
        return configMap.getOrDefault(type, freeConfig);
    }


}
