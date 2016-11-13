package com.epam.fourth.interpreter;

public class NonterminalExpressionNumber extends AbstractMathExpression {

    private double number;

    public NonterminalExpressionNumber(double number) {
        this.number = number;
    }

    public void interpret(Context context) {
        context.pushValue(number);
    }

    @Override
    public String toString() {
        return "NontermExpNumber{" +
                number +
                '}';
    }
}
