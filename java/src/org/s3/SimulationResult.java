package org.s3;

import static org.apache.commons.math3.stat.StatUtils.mean;

public class SimulationResult {

    private double[][][] samples;

    public SimulationResult(double[][][] samples) {
        this.samples = samples;
    }

    public double sampleMean() {
        double[] means = new double[samples.length];
        for (int i = 0; i < samples.length; i++) {
            for (int s = 0; s < samples[i].length; s++) {
                means[i] = mean(samples[i][s]);
            }
        }
        return mean(means);
    }

    public double[] last() {
        int iterations = samples.length;
        int sampleSize = samples[0].length;
        return samples[iterations - 1][sampleSize -1];
    }
}
