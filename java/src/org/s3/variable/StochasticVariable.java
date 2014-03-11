package org.s3.variable;

import org.s3.distribution.Distribution;

public class StochasticVariable implements Variable<RuntimeException> {

    private final String name;
    private final Distribution distribution;

    private double currentValue;

    public StochasticVariable(String name, Distribution distribution) {
        this.name = name;
        this.distribution = distribution;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public double evaluate() {
        currentValue = distribution.sample();
        return currentValue;
    }

    @Override
    public double currentValue() {
        return currentValue;
    }

    @Override
    public void reset() {

    }
}
