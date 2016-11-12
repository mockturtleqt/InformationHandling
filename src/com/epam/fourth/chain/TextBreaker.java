package com.epam.fourth.chain;


import com.epam.fourth.entity.Component;
import com.epam.fourth.entity.TextComposite;

import static com.epam.fourth.constant.Constant.NEW_LINE;
import static com.epam.fourth.constant.Constant.WITH_DELIMETER;
import static com.epam.fourth.entity.TextCompositeType.TEXT;

public class TextBreaker extends BasicBreaker {

    public TextBreaker() {
        this.setSuccessor(new ParagraphBreaker());
    }

    public String[] breakText(String text) {
        return text.split(String.format(WITH_DELIMETER, NEW_LINE));
    }

    public Component getComponent(String text) {
        Component textComposite = new TextComposite(TEXT);
        for (String part : breakText(text)) {
            textComposite.add(successor.getComponent(part));
        }
        return textComposite;
    }
}
