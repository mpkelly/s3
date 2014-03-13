package org.s3.variable;

import org.s3.expression.BadExpressionException;

public class ChoiceVariable implements Variable<BadExpressionException> {

    private final Choices choices;
    private final String name;

    private double currentValue;

    public ChoiceVariable(String name, Choices choices) {
        this.name = name;
        this.choices = choices;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public double evaluate() throws BadExpressionException {
        for(Choices.Choice choice : choices) {
            if (choice.condition.isMet()) {
                currentValue = choice.expression.toDouble();
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
