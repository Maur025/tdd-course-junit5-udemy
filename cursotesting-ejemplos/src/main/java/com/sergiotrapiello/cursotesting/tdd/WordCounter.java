package com.sergiotrapiello.cursotesting.tdd;

import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;

public final class WordCounter {

    private static final String NOT_ALPHANUMERIC_REGEX = "[^a-zA-Z0-9ñÑ]";

    public int count(String text) {
        if (StringUtils.isBlank(text)) {
            return 0;
        }

        int words = 0;

        for (String token : getTokens(text)) {
            if (isAWord(token)) {
                words++;
            }
        }

        return words;
    }

    private String[] getTokens(String text) {
        return StringUtils.split(text);
    }

    private boolean isAWord(String token) {
        return StringUtils.isNotBlank(RegExUtils.removeAll(token, NOT_ALPHANUMERIC_REGEX));
    }
}
