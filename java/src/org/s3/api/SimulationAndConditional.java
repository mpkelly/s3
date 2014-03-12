package org.s3.api;

import org.s3.variable.ChoiceVariable;
import org.s3.variable.Choices;
import org.s3.variable.Variable;

public class SimulationAndConditional extends Simulation implements SimulationAndConditionalBuilder<ChoiceBuilder> {

    private final String name;
    private final Choices choices;
    private final org.s3.Simulation simulation;

    public SimulationAndConditional(String name, Choices choices, org.s3.Simulation simulation) {
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
    public ChoiceBuilder when(String condition) {
        return new Choice(name, simulation, simulation.makeCondition(condition), choices);
    }
}
