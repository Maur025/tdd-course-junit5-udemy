package com.sergiotrapiello.cursotesting.basico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.fail;

import org.apache.commons.lang3.math.Fraction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

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
        } catch (NumberFormatException ex) {
            assertExceptionMessage(ex, "For input string: \"" + wrongNumber + "\"");
        }
    }

    @Test
    @DisplayName(
        "should fail getting fraction from string, wrong number format, assert throws idiom")
    void shouldFailGettingFractionFromString_wrongNumberFormat_assertThrowsIdiom() {
        // GIVEN
        String wrongNumber = "asdfaf";

        // WHEN
        Executable executable = () -> Fraction.getFraction(wrongNumber);

        // THEN

        NumberFormatException ex = assertThrowsExactly(NumberFormatException.class, executable);
        assertExceptionMessage(ex, "For input string: \"" + wrongNumber + "\"");
    }

    @Test
    @DisplayName("should fail getting fraction, denominator is zero, TryCatchIdiom")
    void shouldFailGettingFraction_denominatorIsZero_tryCatchIdiom() {
        // GIVEN
        int numerator = 7;
        int denominator = 0;

        // WHEN
        try {
            Fraction.getFraction(numerator, denominator);

            // THEN
            fail("An exception should be throw");
        } catch (ArithmeticException ex) {
            assertExceptionMessage(ex, "The denominator must not be zero");
        }
    }

    @Test
    @DisplayName("should fail getting fraction, denominator is zero, assert throws Idiom")
    void shouldFailGettingFraction_denominatorIsZero_assertThrowsIdiom() {
        // GIVEN
        int numerator = 7;
        int denominator = 0;

        // WHEN
        Executable executable = () -> Fraction.getFraction(numerator, denominator);
        // THEN

        ArithmeticException ex = assertThrowsExactly(ArithmeticException.class, executable);
        assertExceptionMessage(ex, "The denominator must not be zero");
    }

    private void assertExceptionMessage(Exception ex, String expectedMsg) {
        assertEquals(
            expectedMsg, ex.getMessage(), "The message of exception is not what expected. ");
    }
}
