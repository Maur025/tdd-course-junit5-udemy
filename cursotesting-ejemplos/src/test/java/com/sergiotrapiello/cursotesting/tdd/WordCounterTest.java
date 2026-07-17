package com.sergiotrapiello.cursotesting.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class WordCounterTest {

    //  Para el texto “” debe contar 0 palabras
//  Para el texto “Hola que tal, me llamo Mauro” debe contar 6 palabras.
//  Para el texto “      ” debe contar 0 palabras
//  Para el texto “  …    ” debe contar 0 palabras
//  Para el texto “ .$#-     ” debe contar 0 palabras
//  Para el texto “ 2  ” debe contar 1 palabras
//  Para el texto “.a. B…ñÑ” debe contar 3 palabras
//  Para el texto “¿Hola, qué tal ? quiero esto _ &%$-# y aquello . etc.? ” debe contar 8 palabras
    private WordCounter wordCounter;

    @BeforeEach
    void before() {
        wordCounter = new WordCounter();
    }

    @ParameterizedTest
    @NullAndEmptySource
    void shouldCountZeroWord_nullAndEmptyText(String text) {
        // WHEN
        int result = wordCounter.count(text);

        // THEN
        assertNumWords(0, result);
    }

    @ParameterizedTest
    @CsvSource({
        "'Hola que tal, me llamo Mauro',6",
        "'    ',0",
        "'  …    ',0",
        "' .$#-     ', 0",
        "' 2  ',1", "'.a. B… ñÑ',3",
        "'¿Hola, qué tal ? quiero esto _ &%$-# y aquello . etc.? ',8"
    })
    void shouldCountWords(String text, int numWordsExpected) {
        // WHEN
        int result = wordCounter.count(text);

        // THEN
        assertNumWords(numWordsExpected, result);
    }

    private void assertNumWords(int numWordsExpected, int result) {
        assertEquals(numWordsExpected, result, "El numero de palabras no es el esperado. ");
    }
}
