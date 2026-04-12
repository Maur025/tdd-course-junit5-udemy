package com.sergiotrapiello.cursotesting.basico;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TextNormalizerTest {

    private TextNormalizer normalizer;

    @BeforeEach
    void setup() {
        normalizer = new TextNormalizer();
    }

    @Test
    void shouldNormalizeText() {
        // GIVEN
        String textToNormalize = "AQuello está allí";

        // WHEN
        String actualResult = normalizer.normalizeUppercase(textToNormalize);

        // THEN
        assertEquals("AQUELLO ESTA ALLI", actualResult);
    }

    @Test
    void shouldNormalizeText_empty() {
        // GIVEN
        String textToNormalize = "";

        // WHEN
        String actualResult = normalizer.normalizeUppercase(textToNormalize);

        // THEN
        assertEquals("", actualResult);
    }
}
