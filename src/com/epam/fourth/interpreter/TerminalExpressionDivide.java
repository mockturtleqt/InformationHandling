package com.epam.fourth.interpreter;

public class TerminalExpressionDivide extends AbstractMathExpression {

    public void interpret(Context context) {
        context.pushValue(1 / context.popValue() * context.popValue());
    }

    @Override
    public String toString() {
        return "TermExpDivide{/}";
    }
}
