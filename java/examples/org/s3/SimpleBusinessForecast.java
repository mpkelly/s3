package org.s3;

public class SimpleBusinessForecast {

    // Based on examples used at:
    // http://www.solver.com/monte-carlo-simulation-tutorial

    public static void main(String[] args) throws Exception {
        Simulation simulation = new Simulation()
            .withVariable("Scenario").uniform(1,3)
            .withVariable("Sales").choice()
                .when("Scenario == 1").then("100000")
                .when("Scenario == 2").then("75000")
                .when("Scenario == 3").then("50000")
            .withVariable("SellingPrice").choice()
                .when("Scenario == 1").then("8")
                .when("Scenario == 2").then("10")
                .when("Scenario == 3").then("11")
            .withVariable("UnitCost").triangular(5.5, 6.5, 7.5)
            .withConstant("FixedCosts", 120000)
            .sample("Sales * (SellingPrice - UnitCost) - FixedCosts");

        final SimulationResult result = new SimulationRunner().run(simulation, 20, 100000);

        System.out.println(result.sampleMean());
    }
}
