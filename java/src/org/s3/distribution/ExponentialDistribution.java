package org.s3.distribution;

public class ExponentialDistribution implements Distribution {

    private final org.apache.commons.math3.distribution.ExponentialDistribution exponentialDistribution;

    public ExponentialDistribution(double mean) {
        this.exponentialDistribution = new org.apache.commons.math3.distribution.ExponentialDistribution(mean);
    }

    @Override
    public double sample() {
        return exponentialDistribution.sample();
    }
}
