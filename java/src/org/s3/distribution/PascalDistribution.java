package org.s3.distribution;

public class PascalDistribution implements Distribution {

    private final org.apache.commons.math3.distribution.PascalDistribution pascalDistribution;

    public PascalDistribution(int numberOfFailures, double probabilityOfSuccess) {
        this.pascalDistribution = new org.apache.commons.math3.distribution.PascalDistribution(numberOfFailures, probabilityOfSuccess);
    }

    @Override
    public double sample() {
        return pascalDistribution.sample();
    }
}
