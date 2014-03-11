package org.s3.distribution;

public class WeibullDistribution implements Distribution {

    private final org.apache.commons.math3.distribution.WeibullDistribution weibullDistribution;

    public WeibullDistribution(double alpha, double beta) {
        weibullDistribution = new org.apache.commons.math3.distribution.WeibullDistribution(alpha, beta);
    }

    @Override
    public double sample() {
        return weibullDistribution.sample();
    }
}
