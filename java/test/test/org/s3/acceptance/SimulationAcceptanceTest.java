package test.org.s3.acceptance;

import org.junit.Test;
import org.s3.Simulation;
import org.s3.SimulationResult;
import org.s3.SimulationRunner;
import org.s3.variable.Condition;

import static junit.framework.Assert.assertEquals;

public class SimulationAcceptanceTest {

    private static final double DELTA = 0.1;

    @Test(timeout = 1000)
    public void singleDieSimulation() throws Exception {
        Simulation simulator = new Simulation()
            .withVariable("x").uniform(1,6)
            .sample("x");

        SimulationResult simulationResult = new SimulationRunner().run(simulator, 20, 10000);

        double sampleMean = simulationResult.mean();

        assertEquals("single die throws sample mean", sampleMean, 3.5, DELTA);
     }

    @Test(timeout = 1000)
    public void twoDiceSimulation() throws Exception {
        Simulation simulator = new Simulation()
            .withVariable("x").uniform(1,6)
            .withVariable("y").uniform(1,6)
            .sample("x + y");

        SimulationResult simulationResult = new SimulationRunner().run(simulator, 20, 10000);

        double sampleMean = simulationResult.mean();

        assertEquals("two dice throws sample mean", sampleMean, 7, DELTA);
    }

    @Test(timeout = 2000)
    public void averageThrowsUntilAnEvenNumber() throws Exception {
        Simulation simulator = new Simulation()
            .withVariable("x").uniform(1,6)
            .sample("x");

        Condition untilAnEven = simulator.makeCondition("x % 2 == 0");
        SimulationResult simulationResult = new SimulationRunner().run(simulator, untilAnEven, 10000);

        double sampleMean = simulationResult.mean();

        assertEquals("average throws sample mean", sampleMean, 2, DELTA);
    }
}
