package org.s3;

import org.s3.variable.Condition;

import static org.s3.util.Preconditions.checkState;

public class SimulationRunner {

    public SimulationResult run(Simulation simulation, int sampleSize, int iterations) throws Exception {
        checkState(sampleSize > 0, "sample size must be greater then zero: {0}", sampleSize);
        checkState(iterations > 0, "number of iterations must be greater then zero: {0}", iterations);

        double [][][] samples = new double [iterations] [sampleSize][simulation.sampleLength()];

        for (int i = 0; i < iterations; i++) {
            for (int s = 0; s < sampleSize; s++) {
                samples[i][s] = simulation.run();
            }
            simulation.reset();
        }
        return new SimulationResult(samples);
    }

    public SimulationResult run(Simulation simulation, Condition condition, int iterations) throws Exception {
        checkState(iterations > 0, "number of iterations must be greater then zero: {0}", iterations);

        double [][][] samples = new double [iterations][1][1];

        for (int i = 0; i < iterations; i++) {
            int count = 1;
            simulation.run();
            while(condition.isNotMet()) {
                count++;
                simulation.run();
            }
            samples[i][0][0] = count;
            simulation.reset();
        }
        return new SimulationResult(samples);
    }
}
