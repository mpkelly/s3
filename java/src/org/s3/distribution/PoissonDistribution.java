package org.s3.distribution;

public class PoissonDistribution implements Distribution {

    private final org.apache.commons.math3.distribution.PoissonDistribution poissonDistribution;

    public PoissonDistribution(double mean) {
        poissonDistribution = new org.apache.commons.math3.distribution.PoissonDistribution(mean);
    }

    @Override
    public double sample() {
        return poissonDistribution.sample();
    }
}
