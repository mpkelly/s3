package org.s3.api;

public interface ThenStatement {

    SimulationAndWhenClause<ThenStatement> then(String expression);
}
