package org.s3.expression;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;
import de.congrace.exp4j.UnknownFunctionException;
import de.congrace.exp4j.UnparsableExpressionException;
import org.s3.variable.Variable;

import java.util.LinkedHashMap;
import java.util.Map;

public class Expression {

    private static final double TRUE = 1.0;

    private final Map<String, Variable> variables;
    private final ExpressionBuilder expressionBuilder;

    private Calculable calculable;

    public Expression(Map<String, Variable> variables, String expression)  {
        this.variables = variables;
        this.expressionBuilder = new S3ExpressionBuilder(expression);
    }

    public Expression(String expression)  {
        this(new LinkedHashMap<String, Variable>(), expression);
    }

    public double toDouble() throws BadExpressionException {
        calculable = calculable();
        for (Variable variable: variables.values()) {
            calculable.setVariable(variable.name(), variable.currentValue());
        }
        return calculable.calculate();
    }

    public boolean toBoolean() throws BadExpressionException {
        return toDouble() == TRUE;
    }

    private Calculable calculable() throws BadExpressionException {
        // Lazily loading the calculable this way allows this expression to refer to all variables
        // in the simulation, even if they were declared later
        if (calculable == null) {
            try {
                return calculable = expressionBuilder.withVariableNames(variables.keySet().toArray(new String[variables.size()]))
                        .build();
            } catch (UnknownFunctionException e) {
                throw new BadExpressionException(e);
            } catch (UnparsableExpressionException e) {
                throw new BadExpressionException(e);
            }
        }
        return calculable;
    }
}
