package com.epam.fourth.composite;

import java.util.ArrayList;
import java.util.List;

import static com.epam.fourth.composite.ComponentType.*;

public class TextComposite extends Component {
    private List<Component> components = new ArrayList<>();

    public TextComposite() {
    }

    public TextComposite(ComponentType type) {
        this.type = type;
    }

    public void add(Component component) {
        components.add(component);
    }

    public void remove(Component component) {
        components.remove(component);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Component component : components) {
            stringBuilder.append(component.toString());
            setLayout(stringBuilder, component.getType());
        }
        return stringBuilder.toString();
    }

    private void setLayout(StringBuilder stringBuilder, ComponentType type) {
        if (WORD.equals(type) || NUMBER.equals(type) || PUNCTUATION.equals(type)) {
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



