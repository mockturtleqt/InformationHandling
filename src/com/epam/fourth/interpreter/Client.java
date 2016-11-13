package com.epam.fourth.interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    private ArrayList<AbstractMathExpression> listExpression;

//    public Client(List<String> expression) {
//        InfixToPostfixConverter converter = new InfixToPostfixConverter();
//        converter.convertExpression();
//        listExpression = new ArrayList<>();
//        parse(expression);
//    }
public Client(String infixExpression) {
    listExpression = new ArrayList<>();
    InfixToPostfixConverter converter = new InfixToPostfixConverter();
    List<String> postfixExpression = converter.convertExpression(infixExpression);
    parse(postfixExpression);
}

    private void parse(List<String> expression) {
        for (String lexeme : expression) {
            if (lexeme.isEmpty()) {
                continue;
            }
            char temp = lexeme.charAt(0);
            switch (temp) {
                case '+':
                    listExpression.add(new TerminalExpressionPlus());
                    break;
                case '-':
                    listExpression.add(new TerminalExpressionMinus());
                    break;
                case '/':
                    listExpression.add(new TerminalExpressionDivide());
                    break;
                case '*':
                    listExpression.add(new TerminalExpressionMultiply());
                    break;
                default:
                    Scanner scan = new Scanner(lexeme);
                    if (scan.hasNextInt()) {
                        listExpression.add(new NonterminalExpressionNumber(scan.nextInt()));
                    }
            }
        }
    }

    public Number calculate() {
        Context context = new Context();
        for (AbstractMathExpression terminal : listExpression) {
            terminal.interpret(context);
        }
        return context.popValue();
    }

    @Override
    public String toString() {
        return "Client{" +
                "listExpression=" + listExpression +
                '}';
    }
}
