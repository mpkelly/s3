package org.s3.distribution;

public class UniformIntegerDistribution implements Distribution {

    private final org.apache.commons.math3.distribution.UniformIntegerDistribution uniformIntegerDistribution;

    public UniformIntegerDistribution(int lower, int upper) {
        this.uniformIntegerDistribution = new org.apache.commons.math3.distribution.UniformIntegerDistribution(lower, upper);
    }

    @Override
    public double sample() {
        return uniformIntegerDistribution.sample();
    }
}
