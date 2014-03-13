package org.s3.api;

import org.s3.Simulation;
import org.s3.distribution.*;

public class Variable implements VariableBuilder {

    private final Simulation simulation;
    private final String name;

    public Variable(Simulation simulation, String name) {
        this.simulation = simulation;
        this.name = name;
    }

    @Override
    public SimulationAndWhenClause<SimulationBuilder> beta(double alpha, double beta) {
        return new StochasticVariableWhen(name, simulation, new BetaDistribution(alpha, beta));
    }

    @Override
    public SimulationAndWhenClause<SimulationBuilder> binomial(int trials, double successProbability) {
        return new StochasticVariableWhen(name, simulation, new BinomialDistribution(trials, successProbability));
    }

    @Override
    public SimulationAndWhenClause<SimulationBuilder> cauchy(double median, double scale) {
        return new StochasticVariableWhen(name, simulation, new CauchyDistribution(median, scale));
    }

    @Override
    public SimulationAndWhenClause<SimulationBuilder> chiSquared(double degreesOfFreedom) {
        return new StochasticVariableWhen(name, simulation, new ChiSquaredDistribution(degreesOfFreedom));
    }

    @Override
    public SimulationAndWhenClause<SimulationBuilder> exponential(double mean) {
        return new StochasticVariableWhen(name, simulation, new ExponentialDistribution(mean));
    }

    @Override
    public SimulationAndWhenClause<SimulationBuilder> f(double numeratorDegreesOfFreedom, double nominatorDegreesOfFreedom) {
        return new StochasticVariableWhen(name, simulation, new FDistribution(numeratorDegreesOfFreedom, nominatorDegreesOfFreedom));
    }

    @Override
    public SimulationAndWhenClause<SimulationBuilder> gamma(double shape, double scale) {
        return new StochasticVariableWhen(name, simulation, new GammaDistribution(shape, scale));
    }

    @Override
    public SimulationAndWhenClause<SimulationBuilder> hyperGeometric(int populationSize, int numberOfSuccesses, int sampleSize) {
        return new StochasticVariableWhen(name, simulation, new HypergeometricDistribution(populationSize, numberOfSuccesses, sampleSize));
    }

    @Override
    public SimulationAndWhenClause<SimulationBuilder> logNormal(double scale, double shape) {
        return new StochasticVariableWhen(name, simulation, new LogNormalDistribution(scale, shape));
    }

    @Override
    public SimulationAndWhenClause<SimulationBuilder> normal(double mean, double standardDeviation) {
        return new StochasticVariableWhen(name, simulation, new NormalDistribution(mean, standardDeviation));
    }

    @Override
    public SimulationAndWhenClause<SimulationBuilder> pascal(int numberOfFailures, double probabilityOfSuccess) {
        return new StochasticVariableWhen(name, simulation, new PascalDistribution(numberOfFailures, probabilityOfSuccess));
    }

    @Override
    public SimulationAndWhenClause<SimulationBuilder> poisson(double mean) {
        return new StochasticVariableWhen(name, simulation, new PoissonDistribution(mean));
    }

    @Override
    public SimulationAndWhenClause<SimulationBuilder> t(double degreesOfFreedom) {
        return new StochasticVariableWhen(name, simulation, new TDistribution(degreesOfFreedom));
    }

    @Override
    public SimulationAndWhenClause<SimulationBuilder> triangular(double lower, double mode, double upper) {
        return new StochasticVariableWhen(name, simulation, new TriangularDistribution(lower, mode, upper));
    }

    @Override
    public SimulationAndWhenClause<SimulationBuilder> uniform(int lower, int upper) {
        return new StochasticVariableWhen(name, simulation, new UniformIntegerDistribution(lower, upper));
    }

    @Override
    public SimulationAndWhenClause<SimulationBuilder> uniform(double lower, double upper) {
        return new StochasticVariableWhen(name, simulation, new UniformRealDistribution(lower, upper));
    }

    @Override
    public SimulationAndWhenClause<SimulationBuilder> weibull(double alpha, double beta) {
        return new StochasticVariableWhen(name, simulation, new WeibullDistribution(alpha, beta));
    }

    @Override
    public SimulationAndWhenClause<SimulationBuilder> zipf(int numberOfElements, double exponent) {
        return new StochasticVariableWhen(name, simulation, new ZipfDistribution(numberOfElements, exponent));
    }

    @Override
    public SimulationAndWhenClause<SimulationBuilder> expression(String expression) {
        return new ExpressedVariableWhen(name, simulation, simulation.makeExpression(expression));
    }

    @Override
    public WhenClause<ThenStatement> choice() {
        return new When(name, simulation);
    }
}
