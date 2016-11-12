package com.epam.fourth.action;

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
}
