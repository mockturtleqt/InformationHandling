package com.epam.fourth.chain;

import com.epam.fourth.entity.Component;
import com.epam.fourth.entity.TextComposite;
import com.epam.fourth.entity.TextLeaf;

import static com.epam.fourth.constant.Constant.SENTENCE_TERMINATOR;
import static com.epam.fourth.constant.Constant.SENTENCE_TERMINATOR_PATTERN;
import static com.epam.fourth.entity.TextCompositeType.PARAGRAPH;
import static com.epam.fourth.entity.TextLeafType.PUNCTUATION;


public class ParagraphBreaker extends BasicBreaker {

    public ParagraphBreaker() {
        this.setSuccessor(new SentenceBreaker());
    }

    public Component breakText(String paragraph) {
        Component textComposite = new TextComposite(PARAGRAPH);
        for (String part : paragraph.split(SENTENCE_TERMINATOR)) {
            if (SENTENCE_TERMINATOR_PATTERN.matcher(part).find()) {
                textComposite.add(new TextLeaf(part, PUNCTUATION));
            } else {
                textComposite.add(successor.breakText(part));
            }
        }
        return textComposite;
    }
}
