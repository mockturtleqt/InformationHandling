package com.epam.fourth.entity;

public interface Component {

    void add(Component component);

    void remove(Component component);

    Object getChild(int index);
}
