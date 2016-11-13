package com.epam.fourth.interpreter;

import java.util.regex.Matcher;

import static com.epam.fourth.constant.Constant.DECREMENT_PATTERN;
import static com.epam.fourth.constant.Constant.NUMBER_PATTERN;

public class DecrementHandler {
    public static String decrement(String expression) {
        Matcher decrementPatternMatcher = DECREMENT_PATTERN.matcher(expression);

        while (decrementPatternMatcher.find()) {
            String oldExpression = decrementPatternMatcher.group();

            Matcher numberPatternMatcher = NUMBER_PATTERN.matcher(oldExpression);
            numberPatternMatcher.find();

            Integer newExpression = Integer.parseInt(numberPatternMatcher.group()) - 1;

            expression = expression.replace(oldExpression, newExpression.toString());
        }
        return expression;
    }
}
