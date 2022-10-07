package ru.raianov.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculatorTest {

    private static final String EMPTYSTRINGMESSAGE = "The string cannot be empty";
    private static final String NULLSTRINGMESSAGE = "The string cannot be null";
    private static final List<String> EMPTYLIST = new ArrayList<>();
    private static final List<String> NULLSTRING = null;

    private Calculator calculator;

    private final List<String> InputList = Arrays.asList("3", "10", "5", "+", "*");
    private final double ExpectedResult = 45.0;

    private final List<String> BigInputList = Arrays.asList("2", "4", "5", "/", "5", "3", "-", "5", "4", "^", "^", "*", "+");
    private final double ExpectedBigInputResult = 1.1138771039116688E188;


    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void TestCalculatorExpression() {
        assertEquals(ExpectedResult, calculator.calculate(InputList));
    }

    @Test
    void TestCalculatorBigExpression() {
        assertEquals(ExpectedBigInputResult, calculator.calculate(BigInputList));
    }

    @Test
    void TestCalculatorAppWithEmptyString() {
        IllegalArgumentException calculateIAE = assertThrows(IllegalArgumentException.class, () -> calculator.calculate(EMPTYLIST));
        assertEquals(EMPTYSTRINGMESSAGE, calculateIAE.getMessage());
    }

    @Test
    void TestCalculatorAppWithNullString() {
        IllegalArgumentException calculateIAE = assertThrows(IllegalArgumentException.class, () -> calculator.calculate(NULLSTRING));
        assertEquals(NULLSTRINGMESSAGE, calculateIAE.getMessage());
    }
}
