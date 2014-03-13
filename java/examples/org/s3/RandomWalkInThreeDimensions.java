package org.s3;

public class RandomWalkInThreeDimensions {

    public static void main(String[] args) throws Exception {
        Simulation simulation = new Simulation()
            .withVariable("p").uniform(1, 6)
            .withVariable("x").choice()
                .when("p == 1").then("x - 1")
                .when("p == 2").then("x + 1")
            .withVariable("y").choice()
                .when("p == 3").then("y - 1")
                .when("p == 4").then("y + 1")
            .withVariable("z").choice()
                .when("p == 5").then("z - 1")
                .when("p == 6").then("z + 1")
            .sample("x", "y", "z");

        final SimulationResult result = new SimulationRunner().run(simulation, 50, 1);

        double [] finalPosition = result.last();

        System.out.println("[" + finalPosition[0] + "," + finalPosition[1] + ","  + finalPosition[2] + "]");
    }
}
