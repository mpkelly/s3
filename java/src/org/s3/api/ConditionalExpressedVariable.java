package org.s3.api;

import org.s3.Simulation;
import org.s3.expression.Expression;
import org.s3.variable.ExpressedVariable;
import org.s3.variable.Variable;

public class ConditionalExpressedVariable extends ConditionalVariable {

    private final String name;
    private final Expression expression;

    public ConditionalExpressedVariable(String name, Simulation simulation, Expression expression) {
        super(simulation);
        this.name = name;
        this.expression = expression;
    }

    @Override
    Variable createVariable() {
        return new ExpressedVariable(name, expression);
    }
}