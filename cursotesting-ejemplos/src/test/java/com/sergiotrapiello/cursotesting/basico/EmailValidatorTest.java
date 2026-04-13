package com.sergiotrapiello.cursotesting.basico;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    void shouldValidateEmail_null() {
        // GIVEN
        String emailNull = null;
        // WHEN
        boolean isValid = emailValidator.isValid(emailNull);
        // THEN
        assertFalse(isValid);
    }
}