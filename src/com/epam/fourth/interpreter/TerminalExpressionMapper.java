package com.epam.fourth.interpreter;

import java.util.HashMap;
import java.util.Map;

public class TerminalExpressionMapper {
    public static Map<Character, AbstractMathExpression> map() {
        Map<Character, AbstractMathExpression> expressionMap = new HashMap<>();
        expressionMap.put('+', new TerminalExpressionPlus());
        expressionMap.put('-', new TerminalExpressionMinus());
        expressionMap.put('*', new TerminalExpressionMultiply());
        expressionMap.put('/', new TerminalExpressionDivide());
        return expressionMap;
    }
}
