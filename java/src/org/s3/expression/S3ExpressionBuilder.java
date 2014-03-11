package org.s3.expression;

import de.congrace.exp4j.ExpressionBuilder;
import org.s3.expression.operator.*;

public class S3ExpressionBuilder extends ExpressionBuilder {

    public S3ExpressionBuilder(String expression) {
        super(expression);
        withOperation(new EqualsOperator());
        withOperation(new AndOperator());
        withOperation(new OrOperator());
        withOperation(new LessThanOperator());
        withOperation(new GreaterThanOperator());
    }
}
