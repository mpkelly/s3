package org.s3.variable;

public class ConditionalVariable implements Variable {

    private final Variable variable;
    private final Condition condition;

    public ConditionalVariable(Variable variable, Condition condition) {
        this.variable = variable;
        this.condition = condition;
    }

    @Override
    public String name() {
        return variable.name();
    }

    @Override
    public double evaluate() throws Exception {
        if(condition.isMet()) {
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
