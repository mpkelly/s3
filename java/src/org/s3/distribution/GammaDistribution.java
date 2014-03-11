package org.s3.distribution;

public class GammaDistribution implements Distribution {

    private final org.apache.commons.math3.distribution.GammaDistribution gammaDistribution;

    public GammaDistribution(double shape, double scale) {
        this.gammaDistribution = new org.apache.commons.math3.distribution.GammaDistribution(shape, scale);
    }

    @Override
    public double sample() {
        return gammaDistribution.sample();
    }
}
