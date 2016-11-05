package com.epam.fourth.breaker_chain;

public abstract class BasicBreaker {
    protected BasicBreaker successor;

    public void setSuccessor(BasicBreaker successor) {
        this.successor = successor;
    }

    public abstract String[] breakText(String data);
}
