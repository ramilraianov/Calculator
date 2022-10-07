import ru.raianov.CalculatorApp;
import ru.raianov.calculator.Calculator;
import ru.raianov.formatter.Formatter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.raianov.shuntingyard.ShuntingYard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorAppTest {
    private static final String EMPTYSTRINGMESSAGE = "The string cannot be empty";
    private static final String NULLSTRINGMESSAGE = "The string cannot be null";
    private static final String EMPTYLIST = "";
    private static final String NULLSTRING = null;

    private static final String actualExpressionString = "(1+2)*(3/4)^(5+6)";
    private static final double exceptedDoubleResult = 0.12670540809631348;

    CalculatorApp calculatorApp;
    Calculator calculator;
    Formatter formatter;
    ShuntingYard shuntingYard;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        formatter = new Formatter();
        shuntingYard = new ShuntingYard();
        calculatorApp = new CalculatorApp(calculator, formatter, shuntingYard);
    }

    @Test
    void TestCalculatorAppWithDefaultExpression() {
        assertEquals(exceptedDoubleResult, calculatorApp.calculate(actualExpressionString));
    }

    @Test
    void TestCalculatorAppWithEmptyString() {
        IllegalArgumentException calculateIAE = assertThrows(IllegalArgumentException.class, () -> calculatorApp.calculate(EMPTYLIST));
        assertEquals(EMPTYSTRINGMESSAGE, calculateIAE.getMessage());
    }

    @Test
    void TestCalculatorAppWithNullString() {
        IllegalArgumentException calculateIAE = assertThrows(IllegalArgumentException.class, () -> calculatorApp.calculate(NULLSTRING));
        assertEquals(NULLSTRINGMESSAGE, calculateIAE.getMessage());
    }
}
