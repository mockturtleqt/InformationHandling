package com.epam.fourth.chain;


import com.epam.fourth.entity.Component;
import com.epam.fourth.entity.TextComposite;

import static com.epam.fourth.constant.Constant.NEW_LINE;
import static com.epam.fourth.entity.TextCompositeType.TEXT;


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
