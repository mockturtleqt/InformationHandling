package com.epam.fourth.breaker_chain;


public class TextBreaker extends BasicBreaker {
    static final String NEW_LINE = "\t";

    public String[] breakText(String text) {
        //replacing multiple spaces with a single space
        text = text.replaceAll("\\s+", " ");
        return text.split(NEW_LINE);
    }
}
