package org.s3.api;

import org.s3.Simulation;
import org.s3.variable.Choices;

public class When implements WhenClause<ThenStatement> {

    private final String name;
    private final Simulation simulation;
    private final Choices choices;

    public When(String name, Simulation simulation) {
        this.name = name;
        this.simulation = simulation;
        this.choices = new Choices();
    }

    @Override
    public ThenStatement when(String condition) {
        return new Then(name, simulation, simulation.makeCondition(condition), choices);
    }
}
