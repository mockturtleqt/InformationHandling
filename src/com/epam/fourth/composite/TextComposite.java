package com.epam.fourth.composite;

import java.util.ArrayList;
import java.util.List;

import static com.epam.fourth.composite.ComponentType.PARAGRAPH;
import static com.epam.fourth.composite.ComponentType.SENTENCE;

public class TextComposite extends Component {
    private List<Component> components = new ArrayList<>();

    public TextComposite() {}

    public TextComposite(ComponentType type) {
        this.type = type;
    }

    public void add(Component component) {
        components.add(component);
    }

    public void remove(Component component) {
        components.remove(component);
    }

    public Object getChild(int index) {
        return components.get(index);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        appendRecursively(stringBuilder);
        return stringBuilder.toString();
    }

    public void appendRecursively(StringBuilder stringBuilder) {
        for (Component component : components) {
            component.appendRecursively(stringBuilder);
        }
        setLayout(stringBuilder);
    }

    private void setLayout(StringBuilder stringBuilder) {
        if (SENTENCE.equals(type)) {
            stringBuilder.append(' ');
        } else if (PARAGRAPH.equals(type)) {
            stringBuilder.append('\n');
        }
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }
}



