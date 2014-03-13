package org.s3;


import org.s3.api.SimulationBuilder;
import org.s3.api.VariableBuilder;
import org.s3.expression.Expression;
import org.s3.variable.Condition;
import org.s3.variable.Constant;
import org.s3.variable.Variable;

import java.util.LinkedHashMap;
import java.util.Map;

public class Simulation implements SimulationBuilder {

    private final Map<String, Variable> variables;

    private Expression[] sampleExpressions;

    public Simulation() {
        this.variables = new LinkedHashMap<>();
    }

    public Expression makeExpression(String expression) {
        return new Expression(variables, expression);
    }

    public Condition makeCondition(String expression) {
        return new Condition(makeExpression(expression));
    }

    public Simulation withVariable(Variable variable) {
        variables.put(variable.name(), variable);
        return this;
    }

    @Override
    public VariableBuilder withVariable(String name) {
        return new org.s3.api.Variable(this, name);
    }

    @Override
    public Simulation withConstant(String name, double value) {
        variables.put(name, new Constant(name, value));
        return this;
    }

    @Override
    public Simulation sample(String ... expressions) {
        sampleExpressions =  new Expression[expressions.length];
        for (int i = 0; i < expressions.length; i++) {
            sampleExpressions[i] = makeExpression(expressions[i]);
        }
        return this;
    }

    public double[] run() throws Exception {
        for (Variable variable : variables.values()) {
            variable.evaluate();
        }

        double [] result = new double[sampleExpressions.length];

        for (int i = 0; i < sampleExpressions.length; i++) {
            result[i] = sampleExpressions[i].toDouble();
        }
        return result;
    }

    public void reset() {
        for (Variable variable : variables.values()) {
            variable.reset();
        }
    }

    public int sampleLength() {
        return sampleExpressions.length;
    }
}
