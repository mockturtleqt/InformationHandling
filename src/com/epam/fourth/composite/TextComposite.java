package com.epam.fourth.composite;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements Component {
    private List<Component> components = new ArrayList<>();
    private TextCompositeType type;

    public TextComposite() {
    }

    public TextComposite(TextCompositeType type) {
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
        return "TextComposite{" +
                "components=" + components + "\n" +
                "type=" + type +
                '}';
    }
}



