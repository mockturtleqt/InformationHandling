package com.epam.fourth.composite;

import java.util.List;

public abstract class Component {
    ComponentType type;

    public abstract void add(Component component);

    public abstract void remove(Component component);

    public abstract List<Component> getComponents();

    public abstract void setComponents(List<Component> components);

    public ComponentType getType() {
        return type;
    }
}
