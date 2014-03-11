package org.s3.api;

public interface ChoiceBuilder {

    ConditionalBuilder<SimulationAndChoiceBuilder> select(String expression);
}
