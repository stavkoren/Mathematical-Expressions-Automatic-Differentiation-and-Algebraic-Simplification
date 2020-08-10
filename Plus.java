import java.util.Map;

/**
 * Plus - add two expressions.
 */
public class Plus extends BinaryExpression {
    /**
     * Plus - add two expressions.
     * @param leftExp .
     * @param rightExpression .
     */
    public Plus(Expression leftExp, Expression rightExpression) {
        super(leftExp, rightExpression);
    }
    /**
     * BinaryExpression - constructor.
     * @param leftExp .
     * @param rightExpression .
     */
    public Plus(Expression leftExp, double rightExpression) {
        super(leftExp, rightExpression);
    }
    /**
     * BinaryExpression - constructor.
     * @param leftExp .
     * @param rightExpression .
     */
    public Plus(double leftExp, Expression rightExpression) {
        super(leftExp, rightExpression);
    }
    /**
     * BinaryExpression - constructor.
     * @param leftExp .
     * @param rightExpression .
     */
    public Plus(Expression leftExp, String rightExpression) {
        super(leftExp, rightExpression);
    }
    /**
     * BinaryExpression - constructor.
     * @param leftExp .
     * @param rightExpression .
     */
    public Plus(String leftExp, Expression rightExpression) {
        super(leftExp, rightExpression);
    }
    /**
     * BinaryExpression - constructor.
     * @param leftExp .
     * @param rightExpression .
     */
    public Plus(double leftExp, double rightExpression) {
        super(leftExp, rightExpression);
    }
    /**
     * BinaryExpression - constructor.
     * @param leftExp .
     * @param rightExpression .
     */
    public Plus(String leftExp, String rightExpression) {
        super(leftExp, rightExpression);
    }
    /**
     * BinaryExpression - constructor.
     * @param leftExp .
     * @param rightExpression .
     */
    public Plus(double leftExp, String rightExpression) {
        super(leftExp, rightExpression);
    }
    /**
     * BinaryExpression - constructor.
     * @param leftExp .
     * @param rightExpression .
     */
    public Plus(String leftExp, double rightExpression) {
        super(leftExp, rightExpression);
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
        //return new plus
       return new Plus(getLeft().assign(var, expression), getRight().assign(var, expression));
    }
    /**
     * toString - a nice string representation of the expression.
     * @return string
     */
    @Override
    public String toString() {
        return ("(" + getLeft().toString() + " + " + getRight().toString() + ")");
    }
    /**
     * Evaluate the expression using the variable values provided
     * in the assignment, and return the result.  If the expression
     * contains a variable which is not in the assignment, an exception
     * is thrown.
     * @param assignment .
     * @return result .
     * @throws Exception if the expression contains a variable which is not in the assignment.
     */
    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return (getLeft().evaluate(assignment) + getRight().evaluate(assignment));
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
        return new Plus(getLeft().differentiate(var), getRight().differentiate(var));
    }
    /**
     * Returned a simplified version of the current expression.
     * @return simplfy expression
     */
    public Expression simplify() {
        //simplify left
        Expression left = getLeft().simplify();
        //simplify right
        Expression right = getRight().simplify();
        //check the case: exp+0
        if (right.getClass() == Num.class) {
            //down cast
            try {
                double num = right.evaluate();
                if (num == 0) {
                    //return the exp
                    return left.simplify();
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        //check the case: 0+exp
        if (left.getClass() == Num.class) {
            //down cast
            try {
                double num = left.evaluate();
                if (num == 0) {
                    //return the exp
                    return right.simplify();
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        //if all numbers evaluate it
        if (left.getClass() == Num.class && right.getClass() == Num.class) {
            try {
                return new Num(evaluate());
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        //the expression cannot been simplified
        return new Plus(left.simplify(), right.simplify());
    }
}
