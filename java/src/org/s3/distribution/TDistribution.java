package org.s3.distribution;

public class TDistribution implements Distribution {

    private final org.apache.commons.math3.distribution.TDistribution tDistribution;

    public TDistribution(double degreesOfFreedom) {
        tDistribution = new org.apache.commons.math3.distribution.TDistribution(degreesOfFreedom);
    }

    @Override
    public double sample() {
        return tDistribution.sample();
    }
}
