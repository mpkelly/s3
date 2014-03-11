package org.s3.distribution;

public class UniformRealDistribution implements Distribution {

    private final org.apache.commons.math3.distribution.UniformRealDistribution uniformRealDistribution;

    public UniformRealDistribution(double lower, double upper) {
        uniformRealDistribution = new org.apache.commons.math3.distribution.UniformRealDistribution(lower, upper);
    }

    @Override
    public double sample() {
        return uniformRealDistribution.sample();
    }
}
