package org.s3.distribution;

public class NormalDistribution implements Distribution {

    private final org.apache.commons.math3.distribution.NormalDistribution normalDistribution;

    public NormalDistribution(double mean, double standardDeviation) {
        this.normalDistribution = new org.apache.commons.math3.distribution.NormalDistribution(mean, standardDeviation);
    }

    @Override
    public double sample() {
        return normalDistribution.sample();
    }
}
