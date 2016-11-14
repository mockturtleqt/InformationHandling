package com.epam.fourth.interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Client {
    private ArrayList<AbstractMathExpression> listExpression;
    private Map<Character, AbstractMathExpression> expressionMap;

    public Client(String infixExpression) {
        listExpression = new ArrayList<>();
        InfixToPostfixConverter converter = new InfixToPostfixConverter();
        List<String> postfixExpression = converter.convertExpression(infixExpression);
        expressionMap = TerminalExpressionMapper.map();
        parse(postfixExpression);
    }

    private void parse(List<String> expression) {
        for (String lexeme : expression) {
            if (lexeme.isEmpty()) {
                continue;
            }
            char temp = lexeme.charAt(0);
            if (expressionMap.containsKey(temp)) {
                listExpression.add(expressionMap.get(temp));
            } else {
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
        return context.popValue().intValue();
    }

    @Override
    public String toString() {
        return "Client{" +
                "listExpression=" + listExpression +
                '}';
    }
}
