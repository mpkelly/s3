package org.s3.variable;

import org.s3.expression.BadExpressionException;
import org.s3.expression.Expression;

public class Condition {

    private final Expression expression;

    public Condition(Expression expression) {
        this.expression = expression;
    }

    public boolean isMet() throws BadExpressionException {
        return expression.toBoolean();
    }

    public boolean isNotMet() throws BadExpressionException {
        return !isMet();
    }
}
