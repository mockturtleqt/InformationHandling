package com.epam.fourth.chain;

import com.epam.fourth.composite.Component;
import com.epam.fourth.composite.TextComposite;
import com.epam.fourth.composite.TextLeaf;
import com.epam.fourth.interpreter.Client;

import java.util.regex.Pattern;

import static com.epam.fourth.composite.ComponentType.SENTENCE;
import static com.epam.fourth.composite.ComponentType.PUNCTUATION;
import static com.epam.fourth.composite.ComponentType.NUMBER;
import static com.epam.fourth.composite.ComponentType.WORD;
import static com.epam.fourth.constant.Constant.NUMBER_PATTERN;

public class SentenceBreaker extends BasicBreaker {
    private static final String WORD_DELIMITER = "(?<=[—, '.!?])|(?=[—, '.!?])";

    public Component breakText(String sentence) {
        Component textComposite = new TextComposite(SENTENCE);
        for (String part : sentence.split(WORD_DELIMITER)) {
            part = part.trim();
            if (!part.isEmpty()) {
                if (Pattern.compile(WORD_DELIMITER).matcher(part).find()) {
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
