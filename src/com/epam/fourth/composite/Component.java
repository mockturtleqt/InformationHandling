package com.epam.fourth.composite;

public interface Component {

    void add(Component component);

    void remove(Component component);

    Object getChild(int index);
}
