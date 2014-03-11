package org.s3.api;

import org.s3.Simulation;
import org.s3.expression.Expression;

public abstract class ConditionalVariable extends org.s3.api.Simulation implements SimulationAndConditionalBuilder {

    private final Simulation simulation;

    protected ConditionalVariable(Simulation simulation) {
        super(simulation);
        this.simulation = simulation;
    }

    @Override
    public SimulationBuilder when(String condition) {
        Expression expression = simulation.expression(condition);
        simulation.withVariable(new org.s3.variable.ConditionalVariable(createVariable(), expression));
        return simulation;
    }
}
