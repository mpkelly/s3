package org.s3.distribution;

public class FDistribution implements Distribution {

    private final org.apache.commons.math3.distribution.FDistribution fDistribution;

    public FDistribution(double numeratorDegreesOfFreedom, double nominatorDegreesOfFreedom) {
        this.fDistribution = new org.apache.commons.math3.distribution.FDistribution(numeratorDegreesOfFreedom, nominatorDegreesOfFreedom);
    }

    @Override
    public double sample() {
        return fDistribution.sample();
    }
}
