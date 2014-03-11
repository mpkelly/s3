package org.s3.distribution;

public class ChiSquaredDistribution implements Distribution {

    private final org.apache.commons.math3.distribution.ChiSquaredDistribution chiSquaredDistribution;

    public ChiSquaredDistribution(double degreesOfFreedom) {
        this.chiSquaredDistribution = new org.apache.commons.math3.distribution.ChiSquaredDistribution(degreesOfFreedom);
    }

    @Override
    public double sample() {
        return chiSquaredDistribution.sample();
    }
}
