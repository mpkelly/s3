package org.s3.api;

public abstract class Simulation implements SimulationBuilder {

    private final org.s3.Simulation simulation;

    protected Simulation(org.s3.Simulation simulation) {
        this.simulation = simulation;
    }

    abstract org.s3.variable.Variable createVariable();

    @Override
    public VariableBuilder withVariable(String name) {
        simulation.withVariable(createVariable());
        return simulation.withVariable(name);
    }

    @Override
    public org.s3.Simulation withConstant(String name, double value) {
        simulation.withVariable(createVariable());
        simulation.withConstant(name, value);
        return simulation;
    }

    @Override
    public org.s3.Simulation sample(String... expressions) {
        simulation.withVariable(createVariable());
        return simulation.sample(expressions);
    }
}
