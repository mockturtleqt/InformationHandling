package com.epam.fourth.chain;


import composite.Component;
import composite.TextComposite;

import static com.epam.fourth.constant.Constant.NEW_LINE;
import static composite.TextCompositeType.TEXT;


public class TextBreaker extends BasicBreaker {

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
