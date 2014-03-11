package org.s3.variable;

import org.s3.expression.BadExpressionException;
import org.s3.expression.Expression;

import java.util.Map;

public class ChoiceVariable implements Variable<BadExpressionException> {

    private final Map<Expression, Expression> choices;
    private final String name;

    private double currentValue;

    public ChoiceVariable(String name, Map<Expression, Expression> choices) {
        this.name = name;
        this.choices = choices;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public double evaluate() throws BadExpressionException {
        for(Expression condition: choices.keySet()) {
            if (condition.toBoolean()) {
                currentValue = choices.get(condition).toDouble();
                break;
            }
        }
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
