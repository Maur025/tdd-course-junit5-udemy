package com.sergiotrapiello.cursotesting.basico;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class TextNormalizerTest {

    private TextNormalizer normalizer;

    @BeforeEach
    void setup() {
        normalizer = new TextNormalizer();
    }

    /*@CsvSource({"patatá, PATATA", " AQuello está allí . áéíóú, AQUELLO ESTA ALLI . AEIOU",
        "Sergio García Trapiello, SERGIO GARCIA TRAPIELLO",
        "'Sergio  , García', 'SERGIO  , GARCIA'", "'   ', ''", "' á  ','A'", "null, NULL"})*/

    @ParameterizedTest
    @CsvSource(textBlock = """
        patatá, PATATA
         AQuello está allí . áéíóú, AQUELLO ESTA ALLI . AEIOU
         Sergio García Trapiello, SERGIO GARCIA TRAPIELLO
        """)
    void shouldNormalizeText(String textToNormalize, String expectedResult) {
        // WHEN
        String actualResult = normalizer.normalizeUppercase(textToNormalize);

        // THEN
        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("should ")
    void shouldNormalizeText_nullAndEmpty(String text) {
        // WHEN
        String actualResult = normalizer.normalizeUppercase(text);
        // THEN

        assertEquals("", actualResult);
    }
}
