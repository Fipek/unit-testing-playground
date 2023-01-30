package com.example.unittesting.business;

import com.example.unittesting.enums.Color;
import org.apache.logging.log4j.util.Strings;
import org.assertj.core.internal.Numbers;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Month;
import java.util.EnumSet;
import java.util.Objects;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ParameterTestExampleTest {

    @InjectMocks
    private ParameterTestExample sut;

    // ENUM SOURCE EXAMPLES

    @EnumSource(Color.class)
    @ParameterizedTest
    void canCarPassAccordingToTheTrafficLight_should_only_return_true_when_color_green(final Color color) {
        boolean result = sut.canCarPassAccordingToTheTrafficLight(color);

        if (Objects.requireNonNull(color) == Color.GREEN) {
            assertTrue(result);
        } else {
            assertFalse(result);
        }
    }

    @EnumSource(value = Color.class, names = {"UNDEFINED", "RED", "YELLOW"}, mode = EnumSource.Mode.EXCLUDE)
    @ParameterizedTest
    void canCarPassAccordingToTheTrafficLight_should_only_return_true_when_only_color_green(final Color color) {
        boolean result = sut.canCarPassAccordingToTheTrafficLight(color);

        assertTrue(result);
    }

    @EnumSource(value = Color.class, names = "GREEN", mode = EnumSource.Mode.INCLUDE)
    @ParameterizedTest
    void canCarPassAccordingToTheTrafficLight_should_only_return_false_when_only_color_green_mode_include(final Color color) {
        boolean result = sut.canCarPassAccordingToTheTrafficLight(color);

        assertTrue(result);
    }

    @EnumSource(value = Color.class, names = "GREEN", mode = EnumSource.Mode.EXCLUDE)
    @ParameterizedTest
    void canCarPassAccordingToTheTrafficLight_should_only_return_false_when_color_green_never_come(final Color color) {
        boolean result = sut.canCarPassAccordingToTheTrafficLight(color);

        assertFalse(result);
    }

    @ParameterizedTest
    @EnumSource(value = Month.class, names = ".+BER", mode = EnumSource.Mode.MATCH_ANY)
    void fourMonths_AreEndingWithBer(Month month) {
        EnumSet<Month> months =
                EnumSet.of(Month.SEPTEMBER, Month.OCTOBER, Month.NOVEMBER, Month.DECEMBER);
        assertTrue(months.contains(month));
    }

    // VALUE SOURCE EXAMPLES

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE})
    void isOdd_ShouldReturnTrueForOddNumbers(int number) {
        assertTrue(sut.isOdd(number));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
        assertTrue(sut.isBlank(input));
    }

    @ParameterizedTest
    @NullSource
    void isBlank_ShouldReturnTrueForNullInputs(String input) {
        assertTrue(sut.isBlank(input));
    }

    @ParameterizedTest
    @EmptySource
    void isBlank_ShouldReturnTrueForEmptyStrings(String input) {
        assertTrue(sut.isBlank(input));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void isBlank_ShouldReturnTrueForNullAndEmptyStrings(String input) {
        assertTrue(sut.isBlank(input));
    }

    // METHOD SOURCES EXAMPLE

    private static Stream<Arguments> provideStringsForIsBlank() {
        return Stream.of(
                Arguments.of(null, true),
                Arguments.of("", true),
                Arguments.of("  ", true),
                Arguments.of("not blank", false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideStringsForIsBlank")
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input, boolean expected) {
        assertEquals(expected, Strings.isBlank(input));
    }

}