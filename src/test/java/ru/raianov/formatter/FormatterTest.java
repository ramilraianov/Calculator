package ru.raianov.formatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FormatterTest {
    private static final String EMPTYSTRINGMESSAGE = "The string cannot be empty";
    private static final String NULLSTRINGMESSAGE = "The string cannot be null";
    private static final String EMPTYLIST = "";
    private static final String NULLSTRING = null;

    Formatter formatter;

    private final List<String> expectedList = Arrays.asList("2", "+", "4", "/", "5", "*", "(", "5", "-", "3", ")", "^", "5", "^", "4");
    private final String inputString = "2+4/5*(5-3)^5^4";

    @BeforeEach
    void setUp() {
        formatter = new Formatter();
    }

    @Test
    void testFormatter() {
        assertEquals(expectedList, formatter.format(inputString));
    }

    @Test
    void TestCalculatorAppWithEmptyString() {
        IllegalArgumentException calculateIAE = assertThrows(IllegalArgumentException.class, () -> formatter.format(EMPTYLIST));
        assertEquals(EMPTYSTRINGMESSAGE, calculateIAE.getMessage());
    }

    @Test
    void TestCalculatorAppWithNullString() {
        IllegalArgumentException calculateIAE = assertThrows(IllegalArgumentException.class, () -> formatter.format(NULLSTRING));
        assertEquals(NULLSTRINGMESSAGE, calculateIAE.getMessage());
    }
}
