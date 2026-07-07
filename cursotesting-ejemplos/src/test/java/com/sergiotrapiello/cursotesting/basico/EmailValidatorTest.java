package com.sergiotrapiello.cursotesting.basico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class EmailValidatorTest {

    private EmailValidator emailValidator;

    private static Stream<Arguments> shouldValidateEmailArguments() {
        return Stream.of(
            Arguments.of("usuario@email.com", true), Arguments.of("a@email.com", true),
            Arguments.of("a@b.com", false), Arguments.of("    ", false)
        );
    }

    @BeforeEach
    void setup() {
        emailValidator = new EmailValidator();
    }

    @ParameterizedTest
    @ValueSource(
        strings = {"mmoyapalli@gmail.com", "a@email.com", "mmoya@email.es.com", "a.b@bcd.es"})
    @DisplayName("should valid email")
    void shouldValidEmail(String email) {
        // WHEN
        boolean valid = emailValidator.isValid(email);
        // THEN
        assertValid(valid);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "    ", "usuarioemail.com", "a@b.com", "dsaf"})
    void shouldNotValidateEmail(String email) {
        // WHEN
        boolean valid = emailValidator.isValid(email);

        // THEN
        assertNotValid(valid);
    }

    @ParameterizedTest
    @MethodSource("shouldValidateEmailArguments")
    @DisplayName("should ")
    void shouldValidateEmail(String email, boolean expectedResult) {
        // WHEN
        boolean result = emailValidator.isValid(email);
        // THEN
        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("should validate email")
    void shouldValidateEmail_null_assertThrowsIdiom() {
        // GIVEN
        String emailNull = null;
        // WHEN
        Executable executable = () -> emailValidator.isValid(emailNull);
        // THEN
        IllegalArgumentException ex = assertThrowsExactly(
            IllegalArgumentException.class, executable);

        assertExceptionMessage(ex, "The email to validate cannot be null");
    }

    @Test
    @DisplayName("should validate email")
    void shouldThrowIllegalArgumentException_emailNull_tryCatchIdiom() {
        // GIVEN
        String emailNull = null;
        // WHEN
        try {
            emailValidator.isValid(emailNull);

            // THEN
            fail("An exception should be throw");
        } catch (IllegalArgumentException ex) {
            assertExceptionMessage(ex, "The email to validate cannot be null");
        }
    }

    private void assertExceptionMessage(Exception ex, String expectedMsg) {
        assertEquals(
            expectedMsg, ex.getMessage(), "The message of exception is not what expected. ");
    }

    private void assertNotValid(boolean valid) {
        assertFalse(valid, "The email should NOT be valid");
    }

    private void assertValid(boolean valid) {
        assertTrue(valid, "The email should be valid");
    }
}