package com.epam.fourth.interpreter;

import java.util.ArrayDeque;

class Context {
    private ArrayDeque<Double> contextValues = new ArrayDeque<>();

    Double popValue() {
        return contextValues.pop();
    }

    void pushValue(Double value) {
        contextValues.push(value);
    }

    boolean isEmpty() {
        return contextValues.isEmpty();
    }

    @Override
    public String toString() {
        return "Context{" +
                "contextValues=" + contextValues +
                '}';
    }
}
