package com.epam.fourth.chain;

import com.epam.fourth.entity.Component;
import com.epam.fourth.entity.TextComposite;
import com.epam.fourth.entity.TextLeaf;

import static com.epam.fourth.constant.Constant.*;
import static com.epam.fourth.entity.TextCompositeType.SENTENCE;
import static com.epam.fourth.entity.TextLeafType.*;

public class SentenceBreaker extends BasicBreaker {

    private Component textComposite = new TextComposite(SENTENCE);

    public String[] breakText(String sentence) {
        return sentence.split(String.format(WITH_DELIMETER, WORD_DELIMETER));
    }

    public Component getComponent(String sentence) {
        for (String part : breakText(sentence)) {
            if (!part.isEmpty() && !part.equals(sentence)) {
                if (PUNCTUATION_PATTERN.matcher(part).find()) {
                    textComposite.add(new TextLeaf(part, PUNCTUATION));
                } else if (NUMBER_PATTERN.matcher(part).find()) {
                    textComposite.add(new TextLeaf(part, NUMBER));
                } else {
                    textComposite.add(new TextLeaf(part, WORD));
                }
            }
        }
        return textComposite;
    }
}
