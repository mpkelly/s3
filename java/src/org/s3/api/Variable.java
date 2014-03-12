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
    public SimulationAndConditionalBuilder<SimulationBuilder> beta(double alpha, double beta) {
        return new ConditionalDistributionVariable(name, simulation, new BetaDistribution(alpha, beta));
    }

    @Override
    public SimulationAndConditionalBuilder<SimulationBuilder> binomial(int trials, double successProbability) {
        return new ConditionalDistributionVariable(name, simulation, new BinomialDistribution(trials, successProbability));
    }

    @Override
    public SimulationAndConditionalBuilder<SimulationBuilder> cauchy(double median, double scale) {
        return new ConditionalDistributionVariable(name, simulation, new CauchyDistribution(median, scale));
    }

    @Override
    public SimulationAndConditionalBuilder<SimulationBuilder> chiSquared(double degreesOfFreedom) {
        return new ConditionalDistributionVariable(name, simulation, new ChiSquaredDistribution(degreesOfFreedom));
    }

    @Override
    public SimulationAndConditionalBuilder<SimulationBuilder> exponential(double mean) {
        return new ConditionalDistributionVariable(name, simulation, new ExponentialDistribution(mean));
    }

    @Override
    public SimulationAndConditionalBuilder<SimulationBuilder> f(double numeratorDegreesOfFreedom, double nominatorDegreesOfFreedom) {
        return new ConditionalDistributionVariable(name, simulation, new FDistribution(numeratorDegreesOfFreedom, nominatorDegreesOfFreedom));
    }

    @Override
    public SimulationAndConditionalBuilder<SimulationBuilder> gamma(double shape, double scale) {
        return new ConditionalDistributionVariable(name, simulation, new GammaDistribution(shape, scale));
    }

    @Override
    public SimulationAndConditionalBuilder<SimulationBuilder> hyperGeometric(int populationSize, int numberOfSuccesses, int sampleSize) {
        return new ConditionalDistributionVariable(name, simulation, new HypergeometricDistribution(populationSize, numberOfSuccesses, sampleSize));
    }

    @Override
    public SimulationAndConditionalBuilder<SimulationBuilder> logNormal(double scale, double shape) {
        return new ConditionalDistributionVariable(name, simulation, new LogNormalDistribution(scale, shape));
    }

    @Override
    public SimulationAndConditionalBuilder<SimulationBuilder> normal(double mean, double standardDeviation) {
        return new ConditionalDistributionVariable(name, simulation, new NormalDistribution(mean, standardDeviation));
    }

    @Override
    public SimulationAndConditionalBuilder<SimulationBuilder> pascal(int numberOfFailures, double probabilityOfSuccess) {
        return new ConditionalDistributionVariable(name, simulation, new PascalDistribution(numberOfFailures, probabilityOfSuccess));
    }

    @Override
    public SimulationAndConditionalBuilder<SimulationBuilder> poisson(double mean) {
        return new ConditionalDistributionVariable(name, simulation, new PoissonDistribution(mean));
    }

    @Override
    public SimulationAndConditionalBuilder<SimulationBuilder> t(double degreesOfFreedom) {
        return new ConditionalDistributionVariable(name, simulation, new TDistribution(degreesOfFreedom));
    }

    @Override
    public SimulationAndConditionalBuilder<SimulationBuilder> triangular(double lower, double mode, double upper) {
        return new ConditionalDistributionVariable(name, simulation, new TriangularDistribution(lower, mode, upper));
    }

    @Override
    public SimulationAndConditionalBuilder<SimulationBuilder> uniform(int lower, int upper) {
        return new ConditionalDistributionVariable(name, simulation, new UniformIntegerDistribution(lower, upper));
    }

    @Override
    public SimulationAndConditionalBuilder<SimulationBuilder> uniform(double lower, double upper) {
        return new ConditionalDistributionVariable(name, simulation, new UniformRealDistribution(lower, upper));
    }

    @Override
    public SimulationAndConditionalBuilder<SimulationBuilder> weibull(double alpha, double beta) {
        return new ConditionalDistributionVariable(name, simulation, new WeibullDistribution(alpha, beta));
    }

    @Override
    public SimulationAndConditionalBuilder<SimulationBuilder> zipf(int numberOfElements, double exponent) {
        return new ConditionalDistributionVariable(name, simulation, new ZipfDistribution(numberOfElements, exponent));
    }

    @Override
    public SimulationAndConditionalBuilder<SimulationBuilder> expression(String expression) {
        return new ConditionalExpressedVariable(name, simulation, simulation.makeExpression(expression));
    }

    @Override
    public ConditionalBuilder<ChoiceBuilder> choice() {
        return new Conditional(name, simulation);
    }
}
