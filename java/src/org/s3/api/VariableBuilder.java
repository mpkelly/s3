package org.s3.api;

public interface VariableBuilder {

    SimulationAndConditionalBuilder<SimulationBuilder> beta(double alpha, double beta);

    SimulationAndConditionalBuilder<SimulationBuilder> binomial(int trials, double successProbability);

    SimulationAndConditionalBuilder<SimulationBuilder> cauchy(double median, double scale);

    SimulationAndConditionalBuilder<SimulationBuilder> chiSquared(double degreesOfFreedom);

    SimulationAndConditionalBuilder<SimulationBuilder> exponential(double mean);

    SimulationAndConditionalBuilder<SimulationBuilder> f(double numeratorDegreesOfFreedom, double nominatorDegreesOfFreedom);

    SimulationAndConditionalBuilder<SimulationBuilder> gamma(double shape, double scale);

    SimulationAndConditionalBuilder<SimulationBuilder> hyperGeometric(int populationSize, int numberOfSuccesses, int sampleSize);

    SimulationAndConditionalBuilder<SimulationBuilder> logNormal(double scale, double shape);

    SimulationAndConditionalBuilder<SimulationBuilder> normal(double mean, double standardDeviation);

    SimulationAndConditionalBuilder<SimulationBuilder> pascal(int numberOfFailures, double probabilityOfSuccess);

    SimulationAndConditionalBuilder<SimulationBuilder> poisson(double mean);

    SimulationAndConditionalBuilder<SimulationBuilder> t(double degreesOfFreedom);

    SimulationAndConditionalBuilder<SimulationBuilder> triangular(double lower, double mode, double upper);

    SimulationAndConditionalBuilder<SimulationBuilder> uniform(int lower, int upper);

    SimulationAndConditionalBuilder<SimulationBuilder> uniform(double lower, double upper);

    SimulationAndConditionalBuilder<SimulationBuilder> weibull(double alpha, double beta);

    SimulationAndConditionalBuilder<SimulationBuilder> zipf(int numberOfElements, double exponent);

    SimulationAndConditionalBuilder<SimulationBuilder> expression(String expression);

    ConditionalBuilder<ChoiceBuilder> choice();

}
