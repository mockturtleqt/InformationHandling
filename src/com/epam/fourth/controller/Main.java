package com.epam.fourth.controller;

import com.epam.fourth.action.TextManipulation;
import com.epam.fourth.breaker_chain.BasicBreaker;
import com.epam.fourth.entity.Component;
import com.epam.fourth.entity.TextComposite;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {


        TextManipulation textManipulation = TextManipulation.getInstance();
        String content = textManipulation.readTextFromFile("./text.txt");


        TextComposite textComposite = new TextComposite(content);
        textComposite.operation();

    }
}
