package org.s3.distribution;

public class CauchyDistribution implements Distribution {

    private final org.apache.commons.math3.distribution.CauchyDistribution cauchyDistribution;

    public CauchyDistribution(double median, double scale) {
        this.cauchyDistribution = new org.apache.commons.math3.distribution.CauchyDistribution(median, scale);
    }

    @Override
    public double sample() {
        return cauchyDistribution.sample();
    }
}
