package org.s3;

public class SimpleBusinessForecast {

    // Based on example used at:
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

        final SimulationResult result = new SimulationRunner().run(simulation, 30, 100000);

        System.out.println("Most likely net profit: £" + result.mean());
        System.out.println("Worst case net profit: £" + result.min()[0]);
        System.out.println("Best case net profit: £" + result.max()[0]);

    }
}
