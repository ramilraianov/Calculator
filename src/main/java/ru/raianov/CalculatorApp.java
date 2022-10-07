package ru.raianov;

import ru.raianov.calculator.Calculator;
import ru.raianov.formatter.Formatter;
import ru.raianov.shuntingyard.ShuntingYard;

public class CalculatorApp {

    private final Calculator calculator;
    private final Formatter formatter;
    private final ShuntingYard shuntingYard;

    public CalculatorApp(Calculator calculator, Formatter formatter, ShuntingYard shuntingYard) {

        this.calculator = calculator;
        this.formatter = formatter;
        this.shuntingYard = shuntingYard;
    }

    public double calculate(String input) {

        if (input == null)
            throw new IllegalArgumentException("The string cannot be null");
        if (input.isEmpty())
            throw new IllegalArgumentException("The string cannot be empty");

        return calculator.calculate(shuntingYard.shuntingYard(formatter.format(input)));
    }

}
