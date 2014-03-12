package test.org.s3.unit;

import org.junit.Test;
import org.s3.Simulation;
import org.s3.SimulationResult;
import org.s3.SimulationRunner;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class SimulationTest {

    @Test
    public void smokeTest() throws Exception {
        Simulation simulation = new Simulation()
            .withVariable("a").beta(1, 2)
            .withVariable("b").binomial(1, 1.0)
            .withVariable("c").cauchy(0.5, 0.75)
            .withVariable("d").chiSquared(0.75)
                .when("1 == 1")
            .withVariable("e").exponential(0.25)
            .withVariable("f").f(0.20, 0.80)
            .withVariable("g").gamma(0.33, 0.66)
            .withVariable("h").hyperGeometric(3, 2, 1)
            .withVariable("i").logNormal(0.24, 0.48)
            .withVariable("j").normal(1, 0.2)
                .when("5 % 1 == 0")
            .withVariable("k").pascal(1, 0.01)
            .withVariable("l").poisson(0.20)
            .withVariable("m").t(0.77)
            .withVariable("n").triangular(1,2,3)
            .withVariable("o").uniform(1,10)
            .withVariable("p").uniform(1.0, 10.0)
            .withVariable("q").weibull(0.1, 0.2)
            .withVariable("r").zipf(10, 0.1)
            .withVariable("s").expression("s + 1")
            .withVariable("t").choice()
                .when("5 > 5").then("1 + 2")
                .when("2 == 2").then("2 + 2")
            .withConstant("u", 100)
            .sample("a + b + c + d + e + f + g + h + i + j + k + l + m + n + o + p + q + r + s + t", "u");

        new SimulationRunner().run(simulation, 1, 2);
    }

    @Test
    public void testWhenClause() throws Exception {
        Simulation simulation = new Simulation()
                .withVariable("x").expression("x + 1").when("x == 0")
                .sample("x");
        final SimulationResult result = new SimulationRunner().run(simulation, 2, 1);

        assertEquals("variable choice", 1.0, result.last()[0]);
    }

    @Test
    public void testVariableChoice() throws Exception {
        Simulation simulation = new Simulation()
            .withVariable("x").choice()
                .when("x == 0").then("x + 1")
                .when("x == 1").then("x + 2")
                .when("x == 3").then("x + 3")
            .sample("x");
        final SimulationResult result = new SimulationRunner().run(simulation, 3, 1);

        assertEquals("variable choice", 6.0, result.last()[0]);
    }

    @Test
    public void multipleSamples() throws Exception {
        Simulation simulation = new Simulation()
                .withVariable("x").expression("1")
                .withConstant("y", 2)
                .withVariable("z").expression("3")
                .sample("x", "y", "z");
        final SimulationResult result = new SimulationRunner().run(simulation, 1, 1);

        assertArrayEquals("multiple samples", new double[]{1.0, 2.0, 3.0}, result.last(), 0.0);
    }
}
