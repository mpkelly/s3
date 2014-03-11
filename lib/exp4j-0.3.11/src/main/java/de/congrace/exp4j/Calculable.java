package de.congrace.exp4j;

/**
 * This is the basic result class of the exp4j {@link ExpressionBuilder}
 * 
 * @author frank asseg
 * 
 */
public interface Calculable {
	/**
	 * calculate the result of the expr
	 * 
	 * @return the result of the calculation
	 */
	public double calculate();

	/**
	 * calculate the result of the expr
	 * 
	 * @param variableValues
	 *            the values of the var. The values must be in the same order as the declaration of variables in
	 *            the {@link ExpressionBuilder} used to construct this {@link Calculable} instance
	 * @return the result of the calculation
	 */
	public double calculate(double... variableValues);

	/**
	 * return the expr in reverse polish postfix notation
	 * 
	 * @return the expr used to construct this {@link Calculable}
	 */
	public String getExpression();

	/**
	 * set a var value for the calculation
	 * 
	 * @param name
	 *            the var name
	 * @param value
	 *            the value of the var
	 */
	public void setVariable(String name, double value);
}
