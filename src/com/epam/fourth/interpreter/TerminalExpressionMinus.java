package com.epam.fourth.interpreter;

class TerminalExpressionMinus extends AbstractMathExpression {

    public void interpret(Context context) {
        Double secondValue = context.popValue();
        Double firstValue = 0.0; //if we need to interpret a single negative number ((-5) for example)
        if (!context.isEmpty()) {
            firstValue = context.popValue();
        }
        context.pushValue(firstValue - secondValue);
    }

    @Override
    public String toString() {
        return "-";
    }
}
