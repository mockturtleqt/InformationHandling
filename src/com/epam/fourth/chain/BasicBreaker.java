package com.epam.fourth.chain;

import composite.Component;

public abstract class BasicBreaker {
    protected BasicBreaker successor;

    public void setSuccessor(BasicBreaker successor) {
        this.successor = successor;
    }

    public abstract Component breakText(String data);
}
