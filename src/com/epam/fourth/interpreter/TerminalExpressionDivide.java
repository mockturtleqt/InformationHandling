package com.epam.fourth.interpreter;

public class TerminalExpressionDivide extends AbstractMathExpression {

    public void interpret(Context context) {
        Double secondValue = context.popValue();
        Double firstValue = context.popValue();
        context.pushValue(firstValue / secondValue);
    }

    @Override
    public String toString() {
        return "TermExpDivide{/}";
    }
}
