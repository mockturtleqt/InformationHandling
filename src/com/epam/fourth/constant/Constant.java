package com.epam.fourth.constant;

import java.util.regex.Pattern;

public class Constant {
    public static final String WITH_DELIMETER = "((?<=%1$s)|(?=%1$s))";
    public static final String NEW_LINE = "\t";
    public static final String WORD_DELIMETER = "[,\\s]+";
    public static final String SENTENCE_TERMINATOR = "[.!?]";
    public static final Pattern NUMBER_PATTERN = Pattern.compile("[\\d]+");
    public static final Pattern PUNCTUATION_PATTERN = Pattern.compile("[,.!?]");
}
