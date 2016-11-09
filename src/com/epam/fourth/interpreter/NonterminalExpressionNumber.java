package com.epam.fourth.interpreter;

public class NonterminalExpressionNumber extends AbstractMathExpression {

    private int number;
    public NonterminalExpressionNumber(int number) {
        this.number = number;
    }
    public void interpret(Context context) {
        context.pushValue(number);
    }
}
