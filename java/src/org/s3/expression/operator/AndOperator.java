package org.s3.expression.operator;

import de.congrace.exp4j.CustomOperator;

public class AndOperator extends CustomOperator {

    public AndOperator() {
        super("&&", true, 1, 2);
    }

    @Override
    protected double applyOperation(double[] doubles) {
        return (doubles[0] == 1 && doubles[1] == 1) ? 1 : 0;
    }
}
