package com.epam.fourth.controller;

import com.epam.fourth.action.InfixToPostfixConverter;
import com.epam.fourth.action.TextManipulation;
import com.epam.fourth.entity.TextComposite;
import com.epam.fourth.interpreter.Client;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        TextManipulation textManipulation = TextManipulation.getInstance();
        String content = textManipulation.readTextFromFile("./TextData.txt");
        TextComposite text = new TextComposite(content);
        //text.breakText();

        InfixToPostfixConverter converter = new InfixToPostfixConverter();
        converter.convertExpression("6+9*(3-4)");
        Client interpreter = new Client(converter.getPostfix());
        System.out.println(interpreter.calculate());

        final String WITH_DELIMETER = "((?<=%1$s)|(?=%1$s))";
        String[] sampleArray = "Words. To, match!".split(String.format(WITH_DELIMETER, "[!?.,\\s]"));
        for (String word: sampleArray) {
            System.out.println(word);
        }


    }
}
