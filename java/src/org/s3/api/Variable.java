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
    public SimulationAndConditionalBuilder beta(double alpha, double beta) {
        return new ConditionalDistributionVariable(name, simulation, new BetaDistribution(alpha, beta));
    }

    @Override
    public SimulationAndConditionalBuilder binomial(int trials, double successProbability) {
        return new ConditionalDistributionVariable(name, simulation, new BinomialDistribution(trials, successProbability));
    }

    @Override
    public SimulationAndConditionalBuilder cauchy(double median, double scale) {
        return new ConditionalDistributionVariable(name, simulation, new CauchyDistribution(median, scale));
    }

    @Override
    public SimulationAndConditionalBuilder chiSquared(double degreesOfFreedom) {
        return new ConditionalDistributionVariable(name, simulation, new ChiSquaredDistribution(degreesOfFreedom));
    }

    @Override
    public SimulationAndConditionalBuilder exponential(double mean) {
        return new ConditionalDistributionVariable(name, simulation, new ExponentialDistribution(mean));
    }

    @Override
    public SimulationAndConditionalBuilder f(double numeratorDegreesOfFreedom, double nominatorDegreesOfFreedom) {
        return new ConditionalDistributionVariable(name, simulation, new FDistribution(numeratorDegreesOfFreedom, nominatorDegreesOfFreedom));
    }

    @Override
    public SimulationAndConditionalBuilder gamma(double shape, double scale) {
        return new ConditionalDistributionVariable(name, simulation, new GammaDistribution(shape, scale));
    }

    @Override
    public SimulationAndConditionalBuilder hyperGeometric(int populationSize, int numberOfSuccesses, int sampleSize) {
        return new ConditionalDistributionVariable(name, simulation, new HypergeometricDistribution(populationSize, numberOfSuccesses, sampleSize));
    }

    @Override
    public SimulationAndConditionalBuilder logNormal(double scale, double shape) {
        return new ConditionalDistributionVariable(name, simulation, new LogNormalDistribution(scale, shape));
    }

    @Override
    public SimulationAndConditionalBuilder normal(double mean, double standardDeviation) {
        return new ConditionalDistributionVariable(name, simulation, new NormalDistribution(mean, standardDeviation));
    }

    @Override
    public SimulationAndConditionalBuilder pascal(int numberOfFailures, double probabilityOfSuccess) {
        return new ConditionalDistributionVariable(name, simulation, new PascalDistribution(numberOfFailures, probabilityOfSuccess));
    }

    @Override
    public SimulationAndConditionalBuilder poisson(double mean) {
        return new ConditionalDistributionVariable(name, simulation, new PoissonDistribution(mean));
    }

    @Override
    public SimulationAndConditionalBuilder t(double degreesOfFreedom) {
        return new ConditionalDistributionVariable(name, simulation, new TDistribution(degreesOfFreedom));
    }

    @Override
    public SimulationAndConditionalBuilder triangular(double lower, double mode, double upper) {
        return new ConditionalDistributionVariable(name, simulation, new TriangularDistribution(lower, mode, upper));
    }

    @Override
    public SimulationAndConditionalBuilder uniform(int lower, int upper) {
        return new ConditionalDistributionVariable(name, simulation, new UniformIntegerDistribution(lower, upper));
    }

    @Override
    public SimulationAndConditionalBuilder uniform(double lower, double upper) {
        return new ConditionalDistributionVariable(name, simulation, new UniformRealDistribution(lower, upper));
    }

    @Override
    public SimulationAndConditionalBuilder weibull(double alpha, double beta) {
        return new ConditionalDistributionVariable(name, simulation, new WeibullDistribution(alpha, beta));
    }

    @Override
    public SimulationAndConditionalBuilder zipf(int numberOfElements, double exponent) {
        return new ConditionalDistributionVariable(name, simulation, new ZipfDistribution(numberOfElements, exponent));
    }

    @Override
    public SimulationAndConditionalBuilder expression(String expression) {
        return new ConditionalDerivedVariable(name, simulation, simulation.expression(expression));
    }

    @Override
    public ChoiceBuilder choice() {
        return new Choice(name, simulation);
    }

}
