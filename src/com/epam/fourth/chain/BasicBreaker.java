package com.epam.fourth.chain;

import com.epam.fourth.composite.Component;

public abstract class BasicBreaker {
    BasicBreaker successor;

    void setSuccessor(BasicBreaker successor) {
        this.successor = successor;
    }

    public abstract Component breakText(String data);
}
