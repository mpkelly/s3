package org.s3;

import org.apache.commons.math3.stat.StatUtils;

import static org.apache.commons.math3.stat.StatUtils.sum;

public class SimulationResult {

    private double[][][] samples;

    public SimulationResult(double[][][] samples) {
        this.samples = samples;
    }

    public double mean() {
        double[] means = new double[samples.length];
        for (int i = 0; i < samples.length; i++) {
            for (int s = 0; s < samples[i].length; s++) {
                means[i] = StatUtils.mean(samples[i][s]);
            }
        }
        return StatUtils.mean(means);
    }

    public double[] last() {
        int iterations = samples.length;
        int sampleSize = samples[0].length;
        return samples[iterations - 1][sampleSize - 1];
    }


    public double[] min() {
        return range()[0];
    }

    public double[] max() {
        return range()[1];
    }

    public double[][] range() {
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        int [] minIndex = {0,0};
        int [] maxIndex = {0,0};
        for (int i = 0; i < samples.length; i++) {
            for (int s = 0; s < samples[i].length; s++) {
                double result = sum(samples[i][s]);
                if (result < min) {
                    minIndex[0] = i;
                    minIndex[1] = s;
                    min = result;
                }
                if (result > max) {
                    maxIndex[0] = i;
                    maxIndex[1] = s;
                    max = result;
                }
            }
        }
        return new double[][]{samples[minIndex[0]][minIndex[1]], samples[maxIndex[0]][maxIndex[1]]};
    }
}
