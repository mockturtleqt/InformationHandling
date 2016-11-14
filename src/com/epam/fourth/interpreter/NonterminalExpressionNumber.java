package com.epam.fourth.interpreter;

class NonterminalExpressionNumber extends AbstractMathExpression {

    private double number;

    NonterminalExpressionNumber(double number) {
        this.number = number;
    }

    public void interpret(Context context) {
        context.pushValue(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
