package ru.raianov.shuntingyard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShuntingYardTest {
    ShuntingYard shuntingYard;

    private static final String EMPTYSTRINGMESSAGE = "The string cannot be empty";
    private static final String NULLSTRINGMESSAGE = "The string cannot be null";
    private static final List<String> EMPTYLIST = new ArrayList<>();
    private static final List<String> NULLSTRING = null;

    private final List<String> exceptedList = Arrays.asList("2", "4", "5", "/", "5", "3", "-", "5", "4", "^", "^", "*", "+");
    private final List<String> inputList = Arrays.asList("2", "+", "4", "/", "5", "*", "(", "5", "-", "3", ")", "^", "5", "^", "4");

    @BeforeEach
    void setUp() {
        shuntingYard = new ShuntingYard();
    }

    @Test
    void test1() {
        assertEquals(exceptedList, shuntingYard.shuntingYard(inputList));
    }

    @Test
    void TestShuntingYardWithEmptyString() {
        IllegalArgumentException calculateIAE = assertThrows(IllegalArgumentException.class, () -> shuntingYard.shuntingYard(EMPTYLIST));
        assertEquals(EMPTYSTRINGMESSAGE, calculateIAE.getMessage());
    }

    @Test
    void TestShuntingYardWithNullString() {
        IllegalArgumentException calculateIAE = assertThrows(IllegalArgumentException.class, () -> shuntingYard.shuntingYard(NULLSTRING));
        assertEquals(NULLSTRINGMESSAGE, calculateIAE.getMessage());
    }
}
