package test.org.s3.unit;

import org.junit.Test;
import org.s3.expression.Expression;

import static junit.framework.Assert.assertEquals;

public class ExpressionTest {

    @Test
    public void testEqualsOperatorBoolean() throws Exception {
        boolean result = new Expression("1 == 1").toBoolean();
        assertEquals("equals operator boolean true", true, result);

        result = new Expression("1 == 2").toBoolean();
        assertEquals("equals operator boolean false", false, result);
    }

    @Test
    public void testEqualsOperatorDouble() throws Exception {
        double result = new Expression("(1 == 1) + 5").toDouble();
        assertEquals("equals operator double one", 6.0, result);

        result = new Expression("(1 == 2) + 5").toDouble();
        assertEquals("equals operator double zero", 5.0, result);
    }

    @Test
    public void testAndOperatorBoolean() throws Exception {
        boolean result = new Expression("1 == 1 && 2 == 2").toBoolean();
        assertEquals("and operator boolean true", true, result);

        result = new Expression("1 == 2 && 1 == 1").toBoolean();
        assertEquals("and operator boolean false", false, result);
    }

    @Test
    public void testAndOperatorDouble() throws Exception {
        double result = new Expression("(1 == 1 && 2 == 2) + 5").toDouble();
        assertEquals("and operator boolean one", 6.0, result);

        result = new Expression("(1 == 2 && 1 == 1) + 5").toDouble();
        assertEquals("and operator boolean zero", 5.0, result);
    }

    @Test
    public void testOrOperatorBoolean() throws Exception {
        boolean result = new Expression("1 == 1 || 2 == 2").toBoolean();
        assertEquals("or operator boolean true", true, result);

        result = new Expression("1 == 1 || 2 == 3").toBoolean();
        assertEquals("or operator boolean true", true, result);

        result = new Expression("1 == 2 || 1 == 3").toBoolean();
        assertEquals("or operator boolean false", false, result);
    }

    @Test
    public void testOrOperatorDouble() throws Exception {
        double result = new Expression("(1 == 1 || 2 == 2) + 1").toDouble();
        assertEquals("or operator double one", 2.0, result);

        result = new Expression("(1 == 1 || 2 == 3) + 1").toDouble();
        assertEquals("or operator boolean one", 2.0, result);

        result = new Expression("(1 == 2 || 1 == 3) + 1").toDouble();
        assertEquals("or operator boolean zero", 1.0, result);
    }

    @Test
    public void testGreaterThanOperator() throws Exception {
        boolean result = new Expression("1 > 0").toBoolean();
        assertEquals("greater than operator boolean true", true, result);

        result = new Expression("2 > 2").toBoolean();
        assertEquals("greater than operator boolean false", false, result);
    }

    @Test
    public void testLessThanOperator() throws Exception {
        boolean result = new Expression("1 < 2").toBoolean();
        assertEquals("greater than operator boolean true", true, result);

        result = new Expression("1 < 1").toBoolean();
        assertEquals("greater than operator boolean false", false, result);
    }
}
