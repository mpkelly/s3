package org.s3.expression.operator;

import de.congrace.exp4j.CustomOperator;

public class GreaterThanOperator extends CustomOperator {

    public GreaterThanOperator() {
        super(">", true, 1, 2);
    }

    @Override
    protected double applyOperation(double[] doubles) {
        return doubles[0]  > doubles[1] ? 1 : 0;
    }
}
