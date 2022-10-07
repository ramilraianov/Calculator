package ru.raianov.formatter;

import java.util.ArrayList;
import java.util.List;

public class Formatter {

    public List<String> format(String input) {

        if (input == null)
            throw new IllegalArgumentException("The string cannot be null");
        if (input.isEmpty())
            throw new IllegalArgumentException("The string cannot be empty");

        input = input.replace(" ", "");
        List<String> result = new ArrayList<>();
        char[] chars = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (!Character.isDigit(chars[i]) && chars[i] != '-') {
                if (!sb.isEmpty()) {
                    result.add(sb.toString());
                    sb.setLength(0);
                }
                result.add(String.valueOf(chars[i]));
            } else if (chars[i] == '-') {
                if (i == 0 || !Character.isDigit(chars[i - 1])) {
                    sb.append(chars[i]);
                } else {
                    if (!sb.isEmpty()) {
                        result.add(sb.toString());
                        sb.setLength(0);
                    }
                    result.add(String.valueOf(chars[i]));
                }
            } else {
                sb.append(chars[i]);
            }
        }
        if (!sb.isEmpty())
            result.add(sb.toString());
        return result;
    }
}
