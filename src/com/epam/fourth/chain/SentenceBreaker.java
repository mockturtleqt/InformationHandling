package com.epam.fourth.chain;

import com.epam.fourth.entity.Component;
import com.epam.fourth.entity.TextComposite;
import com.epam.fourth.entity.TextLeaf;

import static com.epam.fourth.constant.Constant.*;
import static com.epam.fourth.entity.TextCompositeType.SENTENCE;
import static com.epam.fourth.entity.TextLeafType.*;

public class SentenceBreaker extends BasicBreaker {

    public Component breakText(String sentence) {
        Component textComposite = new TextComposite(SENTENCE);
        for (String part : sentence.split(WORD_DELIMITER)) {
            part = part.trim();
            if (!part.isEmpty()) {
                if (COMMA_PATTERN.matcher(part).find()) {
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
