package org.s3.distribution;

public class TDistribution implements Distribution {

    private final org.apache.commons.math3.distribution.TDistribution tDistribution;

    public TDistribution(double degressOfFreedom) {
        tDistribution = new org.apache.commons.math3.distribution.TDistribution(degressOfFreedom);
    }

    @Override
    public double sample() {
        return tDistribution.sample();
    }
}
