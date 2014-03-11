package test.org.s3.unit;

import org.junit.Test;
import org.s3.expression.BadExpressionException;
import org.s3.expression.Expression;
import org.s3.variable.*;

import java.util.LinkedHashMap;

import static junit.framework.Assert.assertEquals;

public class VariableTest {

    @Test
    public void testSelfReferencingVariable() throws Exception {
        LinkedHashMap<String, Variable> variables = new LinkedHashMap<>();
        Expression expression  = new Expression(variables, "x + 1");
        Variable x = new DerivedVariable("x", expression);
        variables.put(x.name(), x);

        assertEquals(1.0, x.evaluate());
        assertEquals(2.0, x.evaluate());
    }

    @Test
    public void testResetVariable() throws Exception {
        Variable x = new DerivedVariable("x", new Expression("10"));

        x.evaluate();

        assertEquals(10.0, x.currentValue());
        x.reset();
        assertEquals(0.0, x.currentValue());
    }

    @Test(expected = BadExpressionException.class)
    public void testThrowsBadExpressionException() throws BadExpressionException {
        new Expression("1 abc").toDouble();
    }

    @Test()
    public void testConditionalVariable() throws Exception {
        Expression condition = new Expression("2 == 1");

        Variable x = new ConditionalVariable(new DerivedVariable("x", new Expression("10")), condition);
        assertEquals(x.evaluate(), 0.0);

        condition = new Expression("2 == 2");
        x = new ConditionalVariable(new DerivedVariable("x", new Expression("10")), condition);

        assertEquals(x.evaluate(), 10.0);
    }

    @Test()
    public void testChoiceVariable() throws Exception {
        LinkedHashMap<Expression, Expression> choices = new LinkedHashMap<Expression, Expression>() {{
            put(new Expression("2 == 1"), new Expression("5"));
            put(new Expression("2 == 2"), new Expression("10"));
        }};

        ChoiceVariable x = new ChoiceVariable("x", choices);

        assertEquals(x.evaluate(), 10.0);

        choices = new LinkedHashMap<Expression, Expression>() {{
            put(new Expression("2 == 2"), new Expression("5"));
            put(new Expression("2 == 1"), new Expression("10"));
        }};

        x = new ChoiceVariable("x", choices);

        assertEquals(x.evaluate(), 5.0);

        choices = new LinkedHashMap<Expression, Expression>() {{
            put(new Expression("2 == 1"), new Expression("5"));
            put(new Expression("2 == 1"), new Expression("10"));
        }};

        x = new ChoiceVariable("x", choices);

        assertEquals(x.evaluate(), 0.0);
    }

    @Test()
    public void testConstant() throws Exception {
        Constant x = new Constant("x", 50.0);
        assertEquals(x.evaluate(), 50.0);
        x.reset();
        assertEquals(x.evaluate(), 50.0);
    }
}
