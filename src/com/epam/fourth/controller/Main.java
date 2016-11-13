package com.epam.fourth.controller;

import com.epam.fourth.action.TextManipulation;
import com.epam.fourth.chain.BasicBreaker;
import com.epam.fourth.chain.TextBreaker;
import com.epam.fourth.interpreter.Client;
import composite.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.epam.fourth.constant.Constant.DECREMENT_PATTERN;
import static com.epam.fourth.constant.Constant.INCREMENT_PATTERN;
import static com.epam.fourth.constant.Constant.NUMBER_PATTERN;


public class Main {
    public static void main(String[] args) {
        TextManipulation textManipulation = TextManipulation.getInstance();
        String content = textManipulation.readTextFromFile("./TextData.txt");

//        BasicBreaker breaker = new TextBreaker();
//        Component text = breaker.breakText(content);
//        System.out.println(text);



//        Client interpreter = new Client("6+9*(3-(4--))");
//        System.out.println(interpreter.calculate());
//        String test = "(3--)";
//        String test2 = "(--3)";
//        System.out.println(DECREMENT_PATTERN.matcher(test).find());
//        System.out.println(DECREMENT_PATTERN.matcher(test2).find());
//        System.out.println(INCREMENT_PATTERN.matcher(test).find());
//        System.out.println(INCREMENT_PATTERN.matcher(test2).find());
        //Pattern p = Pattern.compile("(\\d)(.*)(\\d)");
        //String input = "6 example input 4";

//        String input = "6+++7++";
//        Matcher incrementMatcher = INCREMENT_PATTERN.matcher(input);
//
//        while (incrementMatcher.find()) {
//            String oldExpression = incrementMatcher.group();
//            Matcher numberPatternMatcher = NUMBER_PATTERN.matcher(oldExpression);
//            numberPatternMatcher.find();
//            Integer newExpression = Integer.parseInt(numberPatternMatcher.group()) + 1;
//            input = input.replace(oldExpression, newExpression.toString());
//        }
//        System.out.println(input);
    }
}
