import java.util.Map;

/**
 * Sin- sin(expression).
 */
public class Sin extends UnaryExpression {
    /**
     * Sin- constructor.
     *
     * @param expression .
     */
    public Sin(Expression expression) {
        super(expression);
    }
    /**
     * Sin- constructor.
     *
     * @param expression .
     */
    public Sin(double expression) {
        super(expression);
    }
    /**
     * Sin- constructor.
     *
     * @param expression .
     */
    public Sin(String expression) {
        super(expression);
    }

    /**
     * Evaluate the expression using the variable values provided
     * in the assignment, and return the result.  If the expression
     * contains a variable which is not in the assignment, an exception
     * is thrown.
     *
     * @param assignment .
     * @return result .
     * @throws Exception if the expression contains a variable which is not in the assignment.
     */
    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return Math.sin(Math.toRadians(getNextExp().evaluate(assignment)));
    }

    /**
     * assign - Returns a new expression in which all occurrences of the variable
     * ar are replaced with the provided expression (Does not modify the
     * current expression).
     *
     * @param var        .
     * @param expression .
     * @return new expression.
     */
    @Override
    public Expression assign(String var, Expression expression) {
        return new Sin(getNextExp().assign(var, expression));
    }

    /**
     * Returns the expression tree resulting from differentiating
     * the current expression relative to variable `var`.
     *
     * @param var - for differentiate according it.
     * @return differentiate expression .
     */
    @Override
    public Expression differentiate(String var) {
        //if the exp contains only numbers
        if (this.getVariables().size() == 0) {
            //the differentiate is 0
            return new Num(0);
        }
        return new Mult(new Cos(getNextExp()), getNextExp().differentiate(var));
    }

    /**
     * toString - a nice string representation of the expression.
     *
     * @return string
     */
    @Override
    public String toString() {
        return ("sin(" + getNextExp().toString() + ")");
    }

    /**
     * Returned a simplified version of the current expression.
     *
     * @return simplfy expression
     */
    public Expression simplify() {
        //simplfy next exp
        Expression nextExp = getNextExp().simplify();
        //if contains nums evaluate it
        if (nextExp.getClass() == Num.class) {
            try {
                return new Num(evaluate());
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return new Sin(nextExp.simplify());
    }
}
