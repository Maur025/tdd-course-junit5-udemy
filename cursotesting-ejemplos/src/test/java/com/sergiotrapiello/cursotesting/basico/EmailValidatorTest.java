package com.sergiotrapiello.cursotesting.basico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class EmailValidatorTest {

    private EmailValidator emailValidator;

    @BeforeEach
    void setup() {
        emailValidator = new EmailValidator();
    }

    @Test
    @DisplayName("should valid email")
    void shouldValidEmail() {
        // GIVEN
        String emailNull = "mmoyapalli@gmail.com";
        // WHEN
        boolean isValid = emailValidator.isValid(emailNull);
        // THEN
        assertTrue(isValid);
    }

    @Test
    @DisplayName("should validate email two at")
    void shouldValidEmail_twoAt() {
        // GIVEN
        String emailNull = "mmoyapalli@gmai@l.com";
        // WHEN
        boolean isValid = emailValidator.isValid(emailNull);
        // THEN
        assertFalse(isValid);
    }

    @Test
    @DisplayName("should validate email malformed domain")
    void shouldValidEmail_malformedDomain() {
        // GIVEN
        String emailNull = "mmoya-palli@gm-$ail_dddd.com";
        // WHEN
        boolean isValid = emailValidator.isValid(emailNull);
        // THEN
        assertFalse(isValid);
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
}