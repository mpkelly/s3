package org.s3.distribution;

public class BinomialDistribution implements Distribution {

    private final org.apache.commons.math3.distribution.BinomialDistribution binomialDistribution;

    public BinomialDistribution(int trials, double successProbability) {
        this.binomialDistribution = new org.apache.commons.math3.distribution.BinomialDistribution(trials, successProbability);
    }

    @Override
    public double sample() {
        return binomialDistribution.sample();
    }
}
