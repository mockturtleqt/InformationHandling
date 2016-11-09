package com.epam.fourth.controller;

import com.epam.fourth.action.TextManipulation;
import com.epam.fourth.entity.TextComposite;
import com.epam.fourth.interpreter.Client;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {


        TextManipulation textManipulation = TextManipulation.getInstance();
        String content = textManipulation.readTextFromFile("./TextData.txt");
        TextComposite text = new TextComposite(content);
        //text.operation();



        //Client interpreter = new Client(expression);
        //System.out.println("[ " + expression + " ] = " + interpreter.calculate() );


    }
}
