package org.s3.api;

import org.s3.variable.ChoiceVariable;
import org.s3.variable.Choices;
import org.s3.variable.Variable;

public class SimulationAndWhen extends Simulation implements SimulationAndWhenClause<ThenStatement> {

    private final String name;
    private final Choices choices;
    private final org.s3.Simulation simulation;

    public SimulationAndWhen(String name, Choices choices, org.s3.Simulation simulation) {
        super(simulation);
        this.name = name;
        this.choices = choices;
        this.simulation = simulation;
    }

    @Override
    protected Variable createVariable() {
        return new ChoiceVariable(name, choices);
    }

    @Override
    public ThenStatement when(String condition) {
        return new Then(name, simulation, simulation.makeCondition(condition), choices);
    }
}
