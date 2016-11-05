package com.epam.fourth.breaker_chain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.epam.fourth.breaker_chain.ParagraphBreaker.SENTENCE_TERMINATOR;

public class SentenceBreaker extends BasicBreaker {
    private static final String WORD_DELIMETER = "[\\s,]+";

    public String[] breakText(String sentence) {
        final Pattern sentenceTerminator = Pattern.compile(SENTENCE_TERMINATOR);

        Matcher sentenceTerminatorMatcher = sentenceTerminator.matcher(sentence);
        return (sentenceTerminatorMatcher.find() ? successor.breakText(sentence) : sentence.split(WORD_DELIMETER));
    }
}
