package org.s3.api;

import org.s3.Simulation;
import org.s3.expression.Expression;
import org.s3.variable.DerivedVariable;
import org.s3.variable.Variable;

public class ConditionalDerivedVariable extends org.s3.api.ConditionalVariable {

    private final String name;
    private final Expression expression;

    public ConditionalDerivedVariable(String name, Simulation simulation, Expression expression) {
        super(simulation);
        this.name = name;
        this.expression = expression;
    }

    @Override
    Variable createVariable() {
        return new DerivedVariable(name, expression);
    }
}
