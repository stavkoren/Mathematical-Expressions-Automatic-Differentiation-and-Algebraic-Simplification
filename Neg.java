import java.util.Map;

/**
 * Neg- change the value of expression to its negative value.
 */
public class Neg extends UnaryExpression {
    /**
     * Neg- constructor.
      * @param expression .
     */
    public Neg(Expression expression) {
        super(expression);
    }
    /**
     * NEG- constructor.
     *
     * @param expression .
     */
    public Neg(double expression) {
        super(expression);
    }
    /**
     * NWG- constructor.
     *
     * @param expression .
     */
    public Neg(String expression) {
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
        return -getNextExp().evaluate(assignment);
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
        return new Neg(getNextExp().assign(var, expression));
    }
    /**
     * toString - a nice string representation of the expression.
     * @return string
     */
    @Override
    public String toString() {
        //check if it is a num
        if (getNextExp().getClass() == Num.class) {
            try {
                Num num = new Num(new Mult(-1, getNextExp().evaluate()).evaluate());
                if (num.evaluate(null) > 0) {
                    // print it as regular number
                    return  (num.toString());
                }
                return ("(" + num.toString() + ")");
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        }
        return ("(-" + getNextExp().toString() + ")");
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
        return new Neg(getNextExp().differentiate(var));
    }
    /**
     * Returned a simplified version of the current expression.
     * @return simplfy expression
     */
    public Expression simplify() {
        //simplfy next exp
        Expression nextExp = getNextExp().simplify();
        //if contains nums evaluate it
        if (nextExp.getClass() == Num.class) {
            try {
                Expression newNeg = new Neg(nextExp);
                return new Num(newNeg.evaluate());
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return new Neg(nextExp.simplify());
    }
}
