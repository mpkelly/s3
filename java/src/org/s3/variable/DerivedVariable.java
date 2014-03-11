package org.s3.variable;

import org.s3.expression.Expression;
import org.s3.expression.BadExpressionException;

public class DerivedVariable implements Variable<BadExpressionException> {

    private final String name;
    private final Expression expression;

    private double currentValue;

    public DerivedVariable(String name, Expression expression) {
        this.name = name;
        this.expression = expression;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public double evaluate() throws BadExpressionException {
        currentValue = expression.toDouble();
        return currentValue;
    }

    @Override
    public double currentValue() {
        return currentValue;
    }

    @Override
    public void reset() {
        currentValue = 0;
    }
}
