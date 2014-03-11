package org.s3.api;

import org.s3.Simulation;
import org.s3.expression.Expression;

import java.util.Map;

public class Conditional implements ConditionalBuilder<SimulationAndChoiceBuilder> {

    private final String name;
    private final Expression expression;
    private final ChoiceBuilder choice;
    private final Simulation simulation;
    private final Map<Expression, Expression> choices;

    public Conditional(String name, Expression expression, ChoiceBuilder choice, Simulation simulation, Map<Expression, Expression> choices) {
        this.name = name;
        this.expression = expression;
        this.choice = choice;
        this.simulation = simulation;
        this.choices = choices;
    }

    @Override
    public SimulationAndChoiceBuilder when(String condition) {
        choices.put(simulation.expression(condition), expression);
        return new SimulationAndChoice(name, choice, choices, simulation);
    }
}
