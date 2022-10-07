package ru.raianov;

import ru.raianov.calculator.Calculator;
import ru.raianov.formatter.Formatter;
import ru.raianov.shuntingyard.ShuntingYard;

public class Demo {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        Formatter formatter = new Formatter();
        ShuntingYard shuntingYard = new ShuntingYard();
        CalculatorApp calculatorApp = new CalculatorApp(calculator, formatter, shuntingYard);
        String expression1 = "2+2";
        String expression2 = "(1+2)*(3/4)^(5+6)";
        String expression3 = "2+4/5*(5-3)^5^4";
        double result = calculatorApp.calculate(expression3);
        System.out.println(result);
    }
}
