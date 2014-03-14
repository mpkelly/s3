package test.org.s3.unit;

import org.junit.Test;
import org.s3.Simulation;
import org.s3.SimulationRunner;

public class SimulationRunnerTest {

    @Test(expected = IllegalStateException.class)
    public void rejectsSimulationWithZeroOrLessIterations() throws Exception {
        try {
            new SimulationRunner().run(new Simulation(), 1, -1);
        } catch(IllegalStateException expected) {
            new SimulationRunner().run(new Simulation(), 1, 0);
        }
    }

    @Test(expected = IllegalStateException.class)
    public void rejectsSimulationWithZeroOrLesSamples() throws Exception {
        try {
            new SimulationRunner().run(new Simulation(), -1, 1);
        } catch(IllegalStateException expected) {
            new SimulationRunner().run(new Simulation(), 0, 1);
        }
    }
}
