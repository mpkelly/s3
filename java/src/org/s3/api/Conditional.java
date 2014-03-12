package org.s3.api;

import org.s3.Simulation;
import org.s3.variable.Choices;

public class Conditional implements ConditionalBuilder<ChoiceBuilder> {

    private final String name;
    private final Simulation simulation;
    private final Choices choices;

    public Conditional(String name, Simulation simulation) {
        this.name = name;
        this.simulation = simulation;
        this.choices = new Choices();
    }

    @Override
    public ChoiceBuilder when(String condition) {
        return new Choice(name, simulation, simulation.makeCondition(condition), choices);
    }
}
