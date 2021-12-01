package com.phexum.formHandler.domain.feature.spam;

import java.util.Arrays;
import java.util.List;

public class SpamFeatureImpl implements SpamFeature {

    @Override
    public boolean detectSpam(String submitText) {
        //refactor edilecek
        List<String> swear = Arrays.asList("Tugay","Kenan");
        for (String word: swear
             ) {
           if(submitText.toLowerCase().contains(word.toLowerCase())){
               return true;
           }
        }
        return false;
    }
}
