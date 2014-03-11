package org.s3.distribution;

public class ZipfDistribution implements Distribution {

    private final org.apache.commons.math3.distribution.ZipfDistribution zipfDistribution;

    public ZipfDistribution(int numberOfElements, double exponent) {
        zipfDistribution = new org.apache.commons.math3.distribution.ZipfDistribution(numberOfElements, exponent);
    }

    @Override
    public double sample() {
        return zipfDistribution.sample();
    }
}
