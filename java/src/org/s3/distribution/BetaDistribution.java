package org.s3.distribution;

public class BetaDistribution implements Distribution {

    private final org.apache.commons.math3.distribution.BetaDistribution betaDistribution;

    public BetaDistribution(double alpha, double beta) {
        this.betaDistribution = new org.apache.commons.math3.distribution.BetaDistribution(alpha, beta);
    }

    @Override
    public double sample() {
        return betaDistribution.sample();
    }
}
