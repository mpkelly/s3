package org.s3.variable;

public interface Variable<X extends Exception> {

    String name();

    double evaluate() throws X;

    double currentValue();

    void reset();
}
