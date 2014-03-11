package org.s3.variable;

public class Constant implements Variable<RuntimeException> {

    private final String name;
    private final double value;

    public Constant(String name, double value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public double evaluate() {
        return value;
    }

    @Override
    public double currentValue() {
        return value;
    }

    @Override
    public void reset() {

    }
}
