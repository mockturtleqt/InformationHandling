package com.epam.fourth.action;

import com.epam.fourth.composite.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.Iterator;

import static com.epam.fourth.composite.ComponentType.PUNCTUATION;
import static com.epam.fourth.composite.ComponentType.WORD;

public class TextManipulation {
    public void printOrderedSentences(Component textComposite) {
        Map<Integer, Component> sentenceLengthMap = new TreeMap<>();
        for (Component paragraph : textComposite.getComponents()) {
            for (Component sentence : paragraph.getComponents()) {
                //excluding punctuation
                List<Component> lexemes = sentence.getComponents()
                        .stream()
                        .filter(lexeme -> !PUNCTUATION.equals(lexeme.getType()))
                        .collect(Collectors.toList());
                int sentenceLength = lexemes.size();
                sentenceLengthMap.put(sentenceLength, sentence);
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
                //(sentenceLength - 2) - sentence length without sentence terminator
                Collections.swap(sentence.getComponents(), 0, sentenceLength - 2);
            }
        }
    }

    public void removeCertainLexeme(Component textComposite, int length, String firstLetter) {
        for (Component paragraph : textComposite.getComponents()) {
            for (Component sentence : paragraph.getComponents()) {
                Iterator iterator = sentence.getComponents().iterator();
                while (iterator.hasNext()) {
                    Component lexeme = (Component) iterator.next();
                    if (WORD.equals(lexeme.getType()) &&
                            lexeme.toString().length() == length &&
                            lexeme.toString().toLowerCase().startsWith(firstLetter.toLowerCase())) {
                        iterator.remove();
                    }
                }
            }
        }
    }
}
