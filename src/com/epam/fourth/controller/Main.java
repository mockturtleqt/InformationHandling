package com.epam.fourth.controller;

import com.epam.fourth.action.TextManipulation;
import com.epam.fourth.entity.TextComposite;

public class Main {
    public static void main(String[] args) {


        TextManipulation textManipulation = TextManipulation.getInstance();
        String content = textManipulation.readTextFromFile("./text.txt");


        TextComposite textComposite = new TextComposite(content);
        textComposite.operation();

    }
}
