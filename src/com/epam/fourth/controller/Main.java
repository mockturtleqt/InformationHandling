package com.epam.fourth.controller;

import com.epam.fourth.action.TextManipulation;
import com.epam.fourth.action.TextReader;
import com.epam.fourth.chain.BasicBreaker;
import com.epam.fourth.chain.TextBreaker;
import com.epam.fourth.composite.Component;
import com.epam.fourth.interpreter.InfixToPostfixConverter;


public class Main {
    private static final String FILE_NAME = "./TextData.txt";

    public static void main(String[] args) {
        TextReader textReader = new TextReader();
        String content = textReader.readTextFromFile(FILE_NAME);

        BasicBreaker breaker = new TextBreaker();
        Component text = breaker.breakText(content);
        System.out.println(text);

        TextManipulation textManipulation = new TextManipulation();

        textManipulation.printOrderedSentences(text);

        textManipulation.swapFistAndLastLexeme(text);
        System.out.println("\n" + text);

        textManipulation.removeCertainLexeme(text, 9, 'u');
        System.out.println("\n" + text);
//        InfixToPostfixConverter converter = new InfixToPostfixConverter();
//        System.out.println(converter.convertExpression("(-5+1/2*(2+5*2))*1200"));
    }
}
