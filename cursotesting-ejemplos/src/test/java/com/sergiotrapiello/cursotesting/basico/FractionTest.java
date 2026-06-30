package com.sergiotrapiello.cursotesting.basico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.apache.commons.lang3.math.Fraction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FractionTest {

    @Test
    @DisplayName("should get fraction from string")
    void shouldGetFractionFromString() {
        // GIVEN
        String fractionAsText = "3/4";
        double expectedDoubleValue = 0.75d;

        // WHEN
        Fraction fraction = Fraction.getFraction(fractionAsText);

        // THEN
        assertEquals(expectedDoubleValue, fraction.doubleValue());
    }

    @Test
    @DisplayName("should fail getting fraction from string with wrong number format")
    void shouldFailGettingFractionFromString_wrongNumberFormat_tryCatchIdiom() {
        // GIVEN
        String wrongNumber = "asdfaf";

        // WHEN
        try {
            Fraction.getFraction(wrongNumber);

            // THEN
            fail("An exception should be throw");
        } catch (NumberFormatException e) {
            assertEquals(
                "For input string: \"" + wrongNumber + "\"", e.getMessage(),
                "The message of the exception is not what expected. "
            );
        }


    }
}
