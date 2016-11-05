package com.epam.fourth.action;

import com.epam.fourth.breaker_chain.BasicBreaker;
import com.epam.fourth.breaker_chain.ParagraphBreaker;
import com.epam.fourth.breaker_chain.SentenceBreaker;
import com.epam.fourth.breaker_chain.TextBreaker;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class TextManipulation {
    private static Logger logger = Logger.getLogger(TextManipulation.class);
    private static int instanceCounter;
    private static TextManipulation instance;
    private TextBreaker textBreaker;
    private ParagraphBreaker paragraphBreaker;
    private SentenceBreaker sentenceBreaker;

    private TextManipulation() {
    }

    public static TextManipulation getInstance() {
        if (instanceCounter == 0) {
            instance = new TextManipulation();
        }
        return instance;
    }


    public String readTextFromFile(String filepath) {
        String content = null;
        try {
            content = Files.lines(Paths.get(filepath)).collect(Collectors.joining());
        } catch (NoSuchFileException e) {
            logger.fatal(e);
            throw new RuntimeException();
        } catch (IOException e) {
            logger.error(e);
        }
        return content;

    }

    public BasicBreaker getBreaker() {
        textBreaker = new TextBreaker();
        paragraphBreaker = new ParagraphBreaker();
        sentenceBreaker = new SentenceBreaker();

        sentenceBreaker.setSuccessor(paragraphBreaker);
        paragraphBreaker.setSuccessor(textBreaker);
        return sentenceBreaker;
    }
}
