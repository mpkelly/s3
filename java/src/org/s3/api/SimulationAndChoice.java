package org.s3.api;

import org.s3.expression.Expression;
import org.s3.variable.ChoiceVariable;
import org.s3.variable.Variable;

import java.util.Map;

public class SimulationAndChoice extends Simulation implements SimulationAndChoiceBuilder {

    private final String name;
    private final ChoiceBuilder choice;
    private final Map<Expression, Expression> choices;

    public SimulationAndChoice(String name, ChoiceBuilder choice, Map<Expression, Expression> choices, org.s3.Simulation simulation) {
        super(simulation);
        this.name = name;
        this.choice = choice;
        this.choices = choices;
    }

    @Override
    Variable createVariable() {
        return new ChoiceVariable(name, choices);
    }

    public ConditionalBuilder<SimulationAndChoiceBuilder> select(String expression) {
        return choice.select(expression);
    }
}
