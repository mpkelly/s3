package org.s3.api;

import org.s3.Simulation;

public interface SimulationBuilder {

    VariableBuilder withVariable(String name);

    Simulation withConstant(String name, double value);

    Simulation sample(String ... expressions);

}
