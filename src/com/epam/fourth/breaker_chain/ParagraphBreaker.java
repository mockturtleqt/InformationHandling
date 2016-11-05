package com.epam.fourth.breaker_chain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.epam.fourth.breaker_chain.TextBreaker.NEW_LINE;

public class ParagraphBreaker extends BasicBreaker {
    static final String SENTENCE_TERMINATOR = "[.!?]";

    public String[] breakText(String paragraph) {
        final Pattern newLine = Pattern.compile(NEW_LINE);
        Matcher newLineMatcher = newLine.matcher(paragraph);

        return newLineMatcher.find() ? successor.breakText(paragraph) : paragraph.split(SENTENCE_TERMINATOR);
    }
}
