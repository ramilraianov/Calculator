package ru.raianov.calculator;

import java.util.List;
import java.util.Stack;

public class Calculator {

    public double calculate(List<String> input) {

        if (input == null)
            throw new IllegalArgumentException("The string cannot be null");
        if (input.isEmpty())
            throw new IllegalArgumentException("The string cannot be empty");

        Stack<Double> operands = new Stack<>();
        for (String str : input) {
            switch (str) {
                case "+", "-", "*", "/", "^" -> {
                    double right = operands.pop();
                    double left = operands.pop();
                    double value = 0;
                    switch (str) {
                        case "+" -> value = left + right;
                        case "-" -> value = left - right;
                        case "*" -> value = left * right;
                        case "/" -> value = left / right;
                        case "^" -> value = Math.pow(left, right);
                    }
                    operands.push(value);
                }
                default -> operands.push(Double.parseDouble(str));
            }
        }
        return operands.pop();
    }
}
