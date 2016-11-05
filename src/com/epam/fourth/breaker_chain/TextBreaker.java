package com.epam.fourth.breaker_chain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextBreaker extends BasicBreaker{
    static final String NEW_LINE = "\t";

    public String[] breakText(String text) {
        //replacing multiple spaces with a single space
        Pattern spaces = Pattern.compile("\\s+");
        Matcher spaceMatcher = spaces.matcher(text);
        text = spaceMatcher.replaceAll(" ");
        return text.split(NEW_LINE);
    }
}
