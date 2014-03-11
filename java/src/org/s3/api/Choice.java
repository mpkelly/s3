package org.s3.api;

import org.s3.Simulation;
import org.s3.expression.Expression;

import java.util.LinkedHashMap;

public class Choice implements ChoiceBuilder {

    private final String name;
    private final Simulation simulation;
    private final LinkedHashMap<Expression, Expression> choices;

    public Choice(String name, Simulation simulation) {
        this.name = name;
        this.simulation = simulation;
        this.choices = new LinkedHashMap<>();
    }

    @Override
    public ConditionalBuilder<SimulationAndChoiceBuilder> select(String expression) {
        return new Conditional(name, simulation.expression(expression), this, simulation, choices);
    }
}
