package org.s3.expression.operator;

import de.congrace.exp4j.CustomOperator;

public class EqualsOperator extends CustomOperator {

    public EqualsOperator() {
        super("==", true, 2, 2);
    }
    @Override
    protected double applyOperation(double[] doubles) {
        return doubles[0] == doubles[1] ? 1 : 0;
    }
}
