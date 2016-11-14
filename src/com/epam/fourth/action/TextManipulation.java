package com.epam.fourth.action;

import com.epam.fourth.composite.Component;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import static com.epam.fourth.composite.ComponentType.WORD;

public class TextManipulation {
    public void printOrderedSentences(Component textComposite) {
        Map<Integer, Component> sentenceLengthMap = new TreeMap<>();
        for (Component paragraph : textComposite.getComponents()) {
            for (Component sentence : paragraph.getComponents()) {
                int sentenceLength = sentence.getComponents().size();
                if (sentenceLength > 0) {
                    sentenceLengthMap.put(sentenceLength, sentence);
                }
            }
        }
        for (Map.Entry<Integer, Component> entry : sentenceLengthMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public void swapFistAndLastLexeme(Component textComposite) {
        for (Component paragraph : textComposite.getComponents()) {
            for (Component sentence : paragraph.getComponents()) {
                int sentenceLength = sentence.getComponents().size();
                if (sentenceLength > 1) {
                    Collections.swap(sentence.getComponents(), 0, sentenceLength - 1);
                }
            }
        }
    }

    public void removeCertainLexeme(Component textComposite, int length, char firstLetter) {
        for (Component paragraph : textComposite.getComponents()) {
            for (Component sentence : paragraph.getComponents()) {
                Iterator iterator = sentence.getComponents().iterator();
                while (iterator.hasNext()) {
                    Component lexeme = (Component) iterator.next();
                    if (WORD.equals(lexeme.getType()) &&
                            lexeme.toString().length() == length + 1 &&
                            lexeme.toString().charAt(0) == firstLetter) {
                        iterator.remove();
                    }
                }
            }
        }
    }
}
