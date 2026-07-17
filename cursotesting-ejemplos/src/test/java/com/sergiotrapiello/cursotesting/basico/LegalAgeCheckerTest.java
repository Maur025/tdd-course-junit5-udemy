package com.sergiotrapiello.cursotesting.basico;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class LegalAgeCheckerTest {

    private LegalAgeChecker legalAgeChecker;

    private static Stream<LocalDateTime> legalAgeDates() {
        return Stream.of(
            LocalDateTime.of(1998, Month.JULY, 29, 19, 30),
            LocalDateTime.of(2007, Month.JULY, 10, 6, 27)
        );
    }

    private static Stream<LocalDateTime> noLegalAgeDates() {
        return Stream.of(
            LocalDateTime.of(2022, Month.JULY, 29, 19, 30),
            LocalDateTime.of(2009, Month.JULY, 10, 6, 27)
        );
    }

    @BeforeEach
    void setup() {
        legalAgeChecker = new LegalAgeChecker(
            Clock.fixed(Instant.parse("2026-07-10T10:41:00.00Z"), ZoneId.systemDefault()));
    }

    @ParameterizedTest
    @MethodSource("legalAgeDates")
    void shouldBeOfLegalAge(LocalDateTime birthDate) {
        // WHEN
        boolean result = legalAgeChecker.isOfLegalAge(birthDate);

        // THEN
        assertTrue(result, "Should be of legal age.");
    }

    @ParameterizedTest
    @MethodSource("noLegalAgeDates")
    void shouldNotBeOfLegalAge(LocalDateTime birthDate) {
        // WHEN
        boolean result = legalAgeChecker.isOfLegalAge(birthDate);

        // THEN
        assertFalse(result, "Should NOT be of legal age.");
    }
}