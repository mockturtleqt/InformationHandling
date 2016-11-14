package com.epam.fourth.chain;

import com.epam.fourth.composite.Component;
import com.epam.fourth.composite.TextComposite;

import static com.epam.fourth.composite.ComponentType.PARAGRAPH;


public class ParagraphBreaker extends BasicBreaker {
    private static final String SENTENCE_TERMINATOR = "(?<=[.!?])";

    public ParagraphBreaker() {
        this.setSuccessor(new SentenceBreaker());
    }

    public Component breakText(String paragraph) {
        Component textComposite = new TextComposite(PARAGRAPH);
        for (String part : paragraph.split(SENTENCE_TERMINATOR)) {
            textComposite.add(successor.breakText(part));
        }
        return textComposite;
    }
}
