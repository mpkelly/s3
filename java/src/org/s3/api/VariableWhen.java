package org.s3.api;

import org.s3.Simulation;

public abstract class VariableWhen extends org.s3.api.Simulation implements SimulationAndWhenClause<SimulationBuilder> {

    private final Simulation simulation;

    protected VariableWhen(Simulation simulation) {
        super(simulation);
        this.simulation = simulation;
    }

    @Override
    public SimulationBuilder when(String condition) {
        simulation.withVariable(new org.s3.variable.ConditionalVariable(createVariable(), simulation.makeCondition(condition)));
        return simulation;
    }
}
