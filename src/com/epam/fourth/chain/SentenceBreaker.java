package com.epam.fourth.chain;

import com.epam.fourth.interpreter.Client;
import com.epam.fourth.composite.Component;
import com.epam.fourth.composite.TextComposite;
import com.epam.fourth.composite.TextLeaf;

import static com.epam.fourth.constant.Constant.*;
import static com.epam.fourth.composite.TextCompositeType.SENTENCE;
import static com.epam.fourth.composite.TextLeafType.*;

public class SentenceBreaker extends BasicBreaker {

    public Component breakText(String sentence) {
        Component textComposite = new TextComposite(SENTENCE);
        for (String part : sentence.split(WORD_DELIMITER)) {
            part = part.trim();
            if (!part.isEmpty()) {
                if (COMMA_PATTERN.matcher(part).find()) {
                    textComposite.add(new TextLeaf(part, PUNCTUATION));
                } else if (NUMBER_PATTERN.matcher(part).find()) {
                    Client interpreter = new Client(part);
                    part = interpreter.calculate().toString();
                    textComposite.add(new TextLeaf(part, NUMBER));
                } else {
                    textComposite.add(new TextLeaf(part, WORD));
                }
            }
        }
        return textComposite;
    }
}
