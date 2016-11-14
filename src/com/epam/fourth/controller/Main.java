package com.epam.fourth.controller;

import com.epam.fourth.action.TextManipulation;
import com.epam.fourth.action.TextReader;
import com.epam.fourth.chain.BasicBreaker;
import com.epam.fourth.chain.TextBreaker;
import com.epam.fourth.composite.Component;
import com.epam.fourth.interpreter.Client;
import com.epam.fourth.interpreter.InfixToPostfixConverter;


public class Main {
    public static void main(String[] args) {
        TextReader textReader = new TextReader();
        String content = textReader.readTextFromFile("./TextData.txt");

        BasicBreaker breaker = new TextBreaker();
        Component text = breaker.breakText(content);
        Component testText = breaker.breakText(textReader.readTextFromFile("./barney.txt"));
        System.out.println(text);

        TextManipulation textManipulation = new TextManipulation();
        textManipulation.printOrderedSentences(text);
        textManipulation.swapFistAndLastLexeme(text);
        System.out.println("\n" + text);

        textManipulation.removeCertainLexeme(text, 9, 'u');
    }
}
