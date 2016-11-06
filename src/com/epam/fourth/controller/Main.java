package com.epam.fourth.controller;

import com.epam.fourth.action.TextManipulation;
import com.epam.fourth.entity.TextComposite;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {


        TextManipulation textManipulation = TextManipulation.getInstance();
        String content = textManipulation.readTextFromFile("./text.txt");


        //TextComposite textComposite = new TextComposite(content);
        //textComposite.operation();
//        String expression = "++13+2";
//        String digit = "[\\d]+";
//        Pattern digitPattern = Pattern.compile(digit);
//        Matcher digitPatternMatcher = digitPattern.matcher(expression);
//        int end = 0;
//        while (end != expression.length()) {
//            digitPatternMatcher.find();
//            System.out.println(digitPatternMatcher.start());
//            end = digitPatternMatcher.end();
//            System.out.println(end);
//        }


    }
}
