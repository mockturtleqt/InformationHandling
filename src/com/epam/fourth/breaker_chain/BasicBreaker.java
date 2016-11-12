package com.epam.fourth.breaker_chain;

public abstract class BasicBreaker {
    final String WITH_DELIMETER = "((?<=%1$s)(?=%1$s))";
    protected BasicBreaker successor;

    public void setSuccessor(BasicBreaker successor) {
        this.successor = successor;
    }

    public abstract String[] breakText(String data);
}
