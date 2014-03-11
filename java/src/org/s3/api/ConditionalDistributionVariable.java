package org.s3.api;

import org.s3.Simulation;
import org.s3.distribution.Distribution;
import org.s3.variable.StochasticVariable;
import org.s3.variable.Variable;

public class ConditionalDistributionVariable extends org.s3.api.ConditionalVariable {

    private final String name;
    private final Distribution distribution;

    public ConditionalDistributionVariable(String name, Simulation simulation, Distribution distribution) {
        super(simulation);
        this.name = name;
        this.distribution = distribution;
    }

    @Override
    Variable createVariable() {
        return new StochasticVariable(name, distribution);
    }
}
