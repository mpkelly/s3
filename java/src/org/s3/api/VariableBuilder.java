package org.s3.api;

public interface VariableBuilder {

    SimulationAndWhenClause<SimulationBuilder> beta(double alpha, double beta);

    SimulationAndWhenClause<SimulationBuilder> binomial(int trials, double successProbability);

    SimulationAndWhenClause<SimulationBuilder> cauchy(double median, double scale);

    SimulationAndWhenClause<SimulationBuilder> chiSquared(double degreesOfFreedom);

    SimulationAndWhenClause<SimulationBuilder> exponential(double mean);

    SimulationAndWhenClause<SimulationBuilder> f(double numeratorDegreesOfFreedom, double nominatorDegreesOfFreedom);

    SimulationAndWhenClause<SimulationBuilder> gamma(double shape, double scale);

    SimulationAndWhenClause<SimulationBuilder> hyperGeometric(int populationSize, int numberOfSuccesses, int sampleSize);

    SimulationAndWhenClause<SimulationBuilder> logNormal(double scale, double shape);

    SimulationAndWhenClause<SimulationBuilder> normal(double mean, double standardDeviation);

    SimulationAndWhenClause<SimulationBuilder> pascal(int numberOfFailures, double probabilityOfSuccess);

    SimulationAndWhenClause<SimulationBuilder> poisson(double mean);

    SimulationAndWhenClause<SimulationBuilder> t(double degreesOfFreedom);

    SimulationAndWhenClause<SimulationBuilder> triangular(double lower, double mode, double upper);

    SimulationAndWhenClause<SimulationBuilder> uniform(int lower, int upper);

    SimulationAndWhenClause<SimulationBuilder> uniform(double lower, double upper);

    SimulationAndWhenClause<SimulationBuilder> weibull(double alpha, double beta);

    SimulationAndWhenClause<SimulationBuilder> zipf(int numberOfElements, double exponent);

    SimulationAndWhenClause<SimulationBuilder> expression(String expression);

    WhenClause<ThenStatement> choice();

}
