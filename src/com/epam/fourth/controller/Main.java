package com.epam.fourth.controller;

import com.epam.fourth.action.TextManipulation;
import com.epam.fourth.chain.BasicBreaker;
import com.epam.fourth.chain.TextBreaker;
import com.epam.fourth.entity.Component;


public class Main {
    public static void main(String[] args) {
        TextManipulation textManipulation = TextManipulation.getInstance();
        String content = textManipulation.readTextFromFile("./TextData.txt");

        BasicBreaker breaker = new TextBreaker();
        Component text = breaker.getComponent(content);
        System.out.println(text);
    }
}
