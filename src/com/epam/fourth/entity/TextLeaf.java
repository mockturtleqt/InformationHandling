package com.epam.fourth.entity;

public class TextLeaf implements Component {
    private String content;
    private TextLeafType type;

    public TextLeaf() {
    }

    public TextLeaf(String content, TextLeafType type) {
        this.content = content;
        this.type = type;
    }

    public void add(Component component) {
    }

    public void remove(Component component) {
    }

    public Object getChild(int index) {
        return null;
    }

    @Override
    public String toString() {
        return content;
    }


}
