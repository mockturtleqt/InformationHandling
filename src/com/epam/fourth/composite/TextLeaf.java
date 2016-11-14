package com.epam.fourth.composite;

import java.util.ArrayList;
import java.util.List;

public class TextLeaf extends Component {
    private String content;

    public TextLeaf() {
    }

    public TextLeaf(String content, ComponentType type) {
        this.content = content;
        this.type = type;
    }

    public void add(Component component) {
    }

    public void remove(Component component) {
    }

    @Override
    public String toString() {
        return content;
    }

    public List<Component> getComponents() {
        List<Component> singleComponent = new ArrayList<>();
        singleComponent.add(this);
        return singleComponent;
    }

    public void setComponents(List<Component> components) {
    }
}
