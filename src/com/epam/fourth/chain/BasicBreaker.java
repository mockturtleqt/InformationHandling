package com.epam.fourth.chain;

import com.epam.fourth.entity.Component;

public abstract class BasicBreaker {
    protected BasicBreaker successor;

    public void setSuccessor(BasicBreaker successor) {
        this.successor = successor;
    }

    public abstract String[] breakText(String data);

    public abstract Component getComponent(String data);
}
