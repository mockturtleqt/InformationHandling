package com.epam.fourth.constant;

import java.util.regex.Pattern;

public class Constant {
    public static final String NEW_LINE = "(?=[\\t])";
    public static final String SENTENCE_TERMINATOR = "(?<=[.!?])|(?=[.!?])";
    public static final Pattern SENTENCE_TERMINATOR_PATTERN = Pattern.compile("[.?!]");
    public static final String WORD_DELIMITER = "(?<=[—,])|(?=[—, ])";
    public static final Pattern NUMBER_PATTERN = Pattern.compile("(\\d+)");
    public static final Pattern COMMA_PATTERN = Pattern.compile("[,—]");
    public static final Pattern INCREMENT_PATTERN = Pattern.compile("(\\d+\\+\\+|\\+\\+\\d+)");
    public static final Pattern DECREMENT_PATTERN = Pattern.compile("(\\d+--|--\\d+)");
}
