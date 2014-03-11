package org.s3.distribution;

public class LogNormalDistribution implements Distribution {

    private final org.apache.commons.math3.distribution.LogNormalDistribution logNormalDistribution;

    public LogNormalDistribution(double scale, double shape) {
        this.logNormalDistribution = new org.apache.commons.math3.distribution.LogNormalDistribution(scale, shape);
    }

    @Override
    public double sample() {
        return logNormalDistribution.sample();
    }
}
