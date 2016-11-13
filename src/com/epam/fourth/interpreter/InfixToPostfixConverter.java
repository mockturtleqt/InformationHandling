package com.epam.fourth.interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InfixToPostfixConverter {

    //private final static Logger logger = Logger.getLogger(InfixToPostfixConverter.class);
    private Stack<Character> stack = new Stack<>();
    private List<String> postfix = new ArrayList<>();

    public List<String> convertExpression(String infix) {
        StringBuilder buffer = new StringBuilder();

        infix = IncrementHandler.increment(infix);
        infix = DecrementHandler.decrement(infix);
        try {
            Integer singleInteger = Integer.parseInt(infix);
            postfix.add(singleInteger.toString());
            return postfix;
        } catch (NumberFormatException e) {
            //logger.error(e);
            System.out.println(e);
        }

        for (int i = 0; i < infix.length(); i++) {
            char currentCharacter = infix.charAt(i);

            if (!Character.isDigit(currentCharacter)) {
                processOperator(currentCharacter);
            } else {
                buffer.append(currentCharacter);
                /*Check next character. If it isn't a digit or is the last element, go to if block,
                else keep looping and adding characters to buffer.*/
                if (i + 1 == infix.length() || !Character.isDigit(infix.charAt(i + 1))) {
                    postfix.add(buffer.toString()); //add characters from buffer to the output string
                    buffer.setLength(0); //clear buffer
                }
            }
        }
        while (!stack.isEmpty()) {
            postfix.add(stack.pop().toString());
        }
        return postfix;
    }

    private void processOperator(char character) {
        if (stack.isEmpty() || hasGreaterPriority(character, stack.peek()) || character == '(') {
            stack.push(character);
        } else if (character == ')') {
            while (stack.peek() != '(') {
                postfix.add(stack.pop().toString());
            }
            stack.pop(); //to remove '('
        } else {
            postfix.add(stack.pop().toString());
        }
    }

    private boolean hasGreaterPriority(char c1, char c2) {
        return getPrecedence(c1) >= getPrecedence(c2);
    }

    private int getPrecedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        } else {
            return 0;
        }
    }
}
