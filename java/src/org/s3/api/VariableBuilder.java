package org.s3.api;

public interface VariableBuilder {

    SimulationAndConditionalBuilder beta(double alpha, double beta);

    SimulationAndConditionalBuilder binomial(int trials, double successProbability);

    SimulationAndConditionalBuilder cauchy(double median, double scale);

    SimulationAndConditionalBuilder chiSquared(double degreesOfFreedom);

    SimulationAndConditionalBuilder exponential(double mean);

    SimulationAndConditionalBuilder f(double numeratorDegreesOfFreedom, double nominatorDegreesOfFreedom);

    SimulationAndConditionalBuilder gamma(double shape, double scale);

    SimulationAndConditionalBuilder hyperGeometric(int populationSize, int numberOfSuccesses, int sampleSize);

    SimulationAndConditionalBuilder logNormal(double scale, double shape);

    SimulationAndConditionalBuilder normal(double mean, double standardDeviation);

    SimulationAndConditionalBuilder pascal(int numberOfFailures, double probabilityOfSuccess);

    SimulationAndConditionalBuilder poisson(double mean);

    SimulationAndConditionalBuilder t(double degreesOfFreedom);

    SimulationAndConditionalBuilder triangular(double lower, double mode, double upper);

    SimulationAndConditionalBuilder uniform(int lower, int upper);

    SimulationAndConditionalBuilder uniform(double lower, double upper);

    SimulationAndConditionalBuilder weibull(double alpha, double beta);

    SimulationAndConditionalBuilder zipf(int numberOfElements, double exponent);

    SimulationAndConditionalBuilder expression(String expression);

    ChoiceBuilder choice();

}
