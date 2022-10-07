package ru.raianov.shuntingyard;

import java.util.*;

public class ShuntingYard {

    final static Map<String, Operator> OPS = new HashMap<>();

    static {

        for (Operator operator : Operator.values()) {
            OPS.put(operator.symbol, operator);
        }
    }

    public List<String> shuntingYard(List<String> tokens) {

        if (tokens == null)
            throw new IllegalArgumentException("The string cannot be null");
        if (tokens.isEmpty())
            throw new IllegalArgumentException("The string cannot be empty");

        List<String> output = new LinkedList<>();
        Stack<String> stack = new Stack<>();

        for (String token : tokens) {
            if (OPS.containsKey(token)) {
                while (!stack.isEmpty() && OPS.containsKey(stack.peek())) {
                    Operator cOp = OPS.get(token);
                    Operator lOp = OPS.get(stack.peek());
                    if ((cOp.associativity == Associativity.LEFT && cOp.comparePrecedence(lOp) <= 0) ||
                            (cOp.associativity == Associativity.RIGHT && cOp.comparePrecedence(lOp) < 0)) {
                        output.add(stack.pop());
                        continue;
                    }
                    break;
                }
                stack.push(token);
            } else if ("(".equals(token)) {
                stack.push(token);
            } else if (")".equals(token)) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    output.add(stack.pop());
                }
                stack.pop();
            } else {
                output.add(token);
            }
        }
        while (!stack.isEmpty()) {
            output.add(stack.pop());
        }
        return output;
    }
}

