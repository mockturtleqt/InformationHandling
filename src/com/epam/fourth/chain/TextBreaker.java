package com.epam.fourth.chain;

import com.epam.fourth.composite.Component;
import com.epam.fourth.composite.TextComposite;

import static com.epam.fourth.composite.ComponentType.TEXT;

public class TextBreaker extends BasicBreaker {
    private static final String NEW_LINE = "(?=[\\t])";

    public TextBreaker() {
        this.setSuccessor(new ParagraphBreaker());
    }

    public Component breakText(String text) {
        Component textComposite = new TextComposite(TEXT);
        for (String part : text.split(NEW_LINE)) {
            textComposite.add(successor.breakText(part));
        }
        return textComposite;
    }
}
