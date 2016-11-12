package com.epam.fourth.chain;

import com.epam.fourth.entity.Component;
import com.epam.fourth.entity.TextComposite;

import static com.epam.fourth.constant.Constant.SENTENCE_TERMINATOR;
import static com.epam.fourth.constant.Constant.WITH_DELIMETER;
import static com.epam.fourth.entity.TextCompositeType.PARAGRAPH;

public class ParagraphBreaker extends BasicBreaker {

    public ParagraphBreaker() {
        this.setSuccessor(new SentenceBreaker());
    }

    public String[] breakText(String paragraph) {
        return paragraph.split(String.format(WITH_DELIMETER, SENTENCE_TERMINATOR));
    }

    public Component getComponent(String paragraph) {
        Component textComposite = new TextComposite(PARAGRAPH);
        for (String part : breakText(paragraph)) {
            textComposite.add(successor.getComponent(part));
        }
        return textComposite;
    }
}
