package com.epam.fourth.interpreter;

import java.util.ArrayDeque;

public class Context {
    private ArrayDeque<Double> contextValues = new ArrayDeque<>();

    public Double popValue() {
        return contextValues.pop();
    }

    public void pushValue(Double value) {
        contextValues.push(value);
    }

    @Override
    public String toString() {
        return "Context{" +
                "contextValues=" + contextValues +
                '}';
    }
}
