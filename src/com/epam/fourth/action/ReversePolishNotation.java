package com.epam.fourth.action;

import java.util.Stack;

public class ReversePolishNotation {
    private final int ADDITION = 0;
    private final int MINUS = 1;
    private final int MULTIPLICATION = 2;
    private final int DIVISION = 3;

    public int evalRPN(String[] tokens) {

        int returnValue = 0;

        String operators = "+-*/";

        Stack<String> stack = new Stack<String>();

        for(String t : tokens){
            if(!operators.contains(t)){
                stack.push(t);
            }else{
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                int index = operators.indexOf(t);
                switch(index){
                    case ADDITION:
                        stack.push(String.valueOf(a+b));
                        break;
                    case MINUS:
                        stack.push(String.valueOf(b-a));
                        break;
                    case MULTIPLICATION:
                        stack.push(String.valueOf(a*b));
                        break;
                    case DIVISION:
                        stack.push(String.valueOf(b/a));
                        break;
                }
            }
        }

        returnValue = Integer.valueOf(stack.pop());

        return returnValue;

    }
}
