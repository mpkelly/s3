package org.s3.distribution;

public class TriangularDistribution implements Distribution {

    private final org.apache.commons.math3.distribution.TriangularDistribution triangularDistribution;

    public TriangularDistribution(double lower, double mode, double upper) {
        this.triangularDistribution = new org.apache.commons.math3.distribution.TriangularDistribution(lower, mode, upper);
    }

    @Override
    public double sample() {
        return triangularDistribution.sample();
    }
}
