package com.epam.fourth.entity;

import com.epam.fourth.action.TextManipulation;
import com.epam.fourth.breaker_chain.BasicBreaker;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextComposite implements Component{
    private List<Component> components = new ArrayList<>();
    private String content;

    public TextComposite() {}

    public TextComposite(String content) {
        this.content = content;
    }

    public void add(Component component) {
        components.add(component);
    }

    public void remove(Component component) {
        components.remove(component);
    }

    public void operation() {
        TextManipulation textManipulation = TextManipulation.getInstance();
        BasicBreaker breaker = textManipulation.getBreaker();
        String[] brokenText = breaker.breakText(content);
        for (String part : brokenText) {
            if (!part.isEmpty() && !part.equals(content)) {
                components.add(new TextComposite(part));
            }
        }
//        if (brokenText.length != 0) {
//            for (String part : brokenText) {
//                if (!part.isEmpty() && !part.equals(content)) {
//                    components.add(new TextComposite(part));
//                }
//            }
//        }
        System.out.println("content: \n" + content);
        components.forEach(System.out::println);
        components.forEach(Component::operation);
    }

    public Object getChild(int index) {
        return components.get(index);
    }

    public String getContent() {
        return this.content;
    }

    @Override
    public String toString() {
        return "TextComposite{" +
                "content='" + content + '\'' +
                '}';
    }
}


