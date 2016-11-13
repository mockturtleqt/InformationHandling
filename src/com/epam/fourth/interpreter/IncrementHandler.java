package com.epam.fourth.interpreter;

import java.util.regex.Matcher;

import static com.epam.fourth.constant.Constant.INCREMENT_PATTERN;
import static com.epam.fourth.constant.Constant.NUMBER_PATTERN;

public class IncrementHandler {
    public static String increment(String expression) {
        Matcher incrementPatternMatcher = INCREMENT_PATTERN.matcher(expression);

        while (incrementPatternMatcher.find()) {
            String oldExpression = incrementPatternMatcher.group();

            Matcher numberPatternMatcher = NUMBER_PATTERN.matcher(oldExpression);
            numberPatternMatcher.find();

            Integer newExpression = Integer.parseInt(numberPatternMatcher.group()) + 1;

            expression = expression.replace(oldExpression, newExpression.toString());
        }
        return expression;
    }
}
