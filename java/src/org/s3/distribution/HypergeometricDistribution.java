package org.s3.distribution;

public class HypergeometricDistribution implements Distribution {

    private final org.apache.commons.math3.distribution.HypergeometricDistribution hypergeometricDistribution;

    public HypergeometricDistribution(int populationSize, int numberOfSuccesses, int sampleSize) {
        this.hypergeometricDistribution = new org.apache.commons.math3.distribution.HypergeometricDistribution(populationSize, numberOfSuccesses, sampleSize);
    }

    @Override
    public double sample() {
        return hypergeometricDistribution.sample();
    }
}
