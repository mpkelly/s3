package org.s3;

public class RandomWalkInThreeDimensions {

    public static void main(String[] args) throws Exception {
        Simulation simulation = new Simulation()
            .withVariable("p").uniform(1, 6)
            .withVariable("x").choice()
                .select("x - 1").when("p == 1")
                .select("x + 1").when("p == 2")
            .withVariable("y").choice()
                .select("y - 1").when("p == 3")
                .select("y + 1").when("p == 4")
            .withVariable("z").choice()
                .select("z - 1").when("p == 5")
                .select("z + 1").when("p == 6")
            .sample("x", "y", "z");

        final SimulationResult result = new SimulationRunner().run(simulation, 50, 1);

        double [] finalPosition = result.last();

        System.out.println(finalPosition[0] + "|" + finalPosition[1] + "|"  + finalPosition[2]);
    }
}
