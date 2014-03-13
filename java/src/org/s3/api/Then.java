package org.s3.api;

import org.s3.Simulation;
import org.s3.variable.Choices;
import org.s3.variable.Condition;

public class Then implements ThenStatement {

    private final String name;
    private final Simulation simulation;
    private final Condition condition;
    private final Choices choices;

    public Then(String name, Simulation simulation, Condition condition, Choices choices) {
        this.name = name;
        this.simulation = simulation;
        this.condition = condition;
        this.choices = choices;
    }

    @Override
    public SimulationAndWhenClause<ThenStatement> then(String expression) {
        choices.add(condition, simulation.makeExpression(expression));
        return new SimulationAndWhen(name, choices, simulation);
    }
}
