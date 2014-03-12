package org.s3.api;

public interface ChoiceBuilder {

    SimulationAndConditionalBuilder<ChoiceBuilder> then(String expression);
}
