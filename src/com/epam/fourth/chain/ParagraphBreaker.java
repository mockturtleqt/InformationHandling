package com.epam.fourth.chain;

import com.epam.fourth.composite.Component;
import com.epam.fourth.composite.TextComposite;
import com.epam.fourth.composite.TextLeaf;

import java.util.regex.Pattern;

import static com.epam.fourth.composite.ComponentType.PARAGRAPH;
import static com.epam.fourth.composite.ComponentType.PUNCTUATION;


public class ParagraphBreaker extends BasicBreaker {
    private static final String SENTENCE_TERMINATOR = "(?<=[.!?])|(?=[.!?])";

    public ParagraphBreaker() {
        this.setSuccessor(new SentenceBreaker());
    }

    public Component breakText(String paragraph) {
        Component textComposite = new TextComposite(PARAGRAPH);
        for (String part : paragraph.split(SENTENCE_TERMINATOR)) {
            if (Pattern.compile(SENTENCE_TERMINATOR).matcher(part).find()) {
                textComposite.add(new TextLeaf(part, PUNCTUATION));
            } else {
                textComposite.add(successor.breakText(part));
            }
        }
        return textComposite;
    }
}
