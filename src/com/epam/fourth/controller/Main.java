package com.epam.fourth.controller;

import com.epam.fourth.action.TextManipulation;
import com.epam.fourth.chain.BasicBreaker;
import com.epam.fourth.chain.TextBreaker;
import com.epam.fourth.composite.Component;


public class Main {
    public static void main(String[] args) {
        TextManipulation textManipulation = TextManipulation.getInstance();
        String content = textManipulation.readTextFromFile("./TextData.txt");

        BasicBreaker breaker = new TextBreaker();
        Component text = breaker.breakText(content);
        System.out.println(text);


//        Client interpreter = new Client("6+9*(3-(4--))");
//        System.out.println(interpreter.calculate());
    }
}
