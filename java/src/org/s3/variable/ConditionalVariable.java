package org.s3.variable;

import org.s3.expression.Expression;

public class ConditionalVariable implements Variable {

    private final Variable variable;
    private final Expression condition;

    public ConditionalVariable(Variable variable, Expression condition) {
        this.variable = variable;
        this.condition = condition;
    }

    @Override
    public String name() {
        return variable.name();
    }

    @Override
    public double evaluate() throws Exception {
        if(condition.toBoolean()) {
            variable.evaluate();
        }
        return currentValue();
    }

    @Override
    public double currentValue() {
        return variable.currentValue();
    }

    @Override
    public void reset() {
        variable.reset();
    }
}
