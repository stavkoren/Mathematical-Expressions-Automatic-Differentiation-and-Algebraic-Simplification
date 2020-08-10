import java.util.Map;

/**
 * Pow- pow a number.
 */
public class Pow extends BinaryExpression {
    /**
     * Pow - pow a number.
     * @param leftExp         .
     * @param rightExpression .
     */
    public Pow(Expression leftExp, Expression rightExpression) {
        super(leftExp, rightExpression);
    }

    /**
     * BinaryExpression - constructor.
     *
     * @param leftExp         .
     * @param rightExpression .
     */
    public Pow(Expression leftExp, double rightExpression) {
        super(leftExp, rightExpression);
    }

    /**
     * BinaryExpression - constructor.
     *
     * @param leftExp         .
     * @param rightExpression .
     */
    public Pow(double leftExp, Expression rightExpression) {
        super(leftExp, rightExpression);
    }

    /**
     * BinaryExpression - constructor.
     *
     * @param leftExp         .
     * @param rightExpression .
     */
    public Pow(Expression leftExp, String rightExpression) {
        super(leftExp, rightExpression);
    }

    /**
     * BinaryExpression - constructor.
     *
     * @param leftExp         .
     * @param rightExpression .
     */
    public Pow(String leftExp, Expression rightExpression) {
        super(leftExp, rightExpression);
    }

    /**
     * BinaryExpression - constructor.
     *
     * @param leftExp         .
     * @param rightExpression .
     */
    public Pow(double leftExp, double rightExpression) {
        super(leftExp, rightExpression);
    }

    /**
     * BinaryExpression - constructor.
     *
     * @param leftExp         .
     * @param rightExpression .
     */
    public Pow(String leftExp, String rightExpression) {
        super(leftExp, rightExpression);
    }

    /**
     * BinaryExpression - constructor.
     *
     * @param leftExp         .
     * @param rightExpression .
     */
    public Pow(double leftExp, String rightExpression) {
        super(leftExp, rightExpression);
    }

    /**
     * BinaryExpression - constructor.
     *
     * @param leftExp         .
     * @param rightExpression .
     */
    public Pow(String leftExp, double rightExpression) {
        super(leftExp, rightExpression);
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
        return Math.pow(getLeft().evaluate(assignment), getRight().evaluate(assignment));
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
        return new Pow(getLeft().assign(var, expression), getRight().assign(var, expression));
    }

    /**
     * toString - a nice string representation of the expression.
     *
     * @return string
     */
    @Override
    public String toString() {
        return ("(" + getLeft().toString() + "^" + getRight().toString() + ")");
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
        Expression a = new Mult(getLeft().differentiate(var), new Div(getRight(), getLeft()));
        Expression b = new Mult(getRight().differentiate(var), new Log("e", getLeft()));
        Expression c = new Mult(this, new Plus(a, b));
        //differentiate by pow formoula
        return c;
    }

    /**
     * Returned a simplified version of the current expression.
     *
     * @return simplfy expression
     */
    public Expression simplify() {
        //simplify left
        Expression left = getLeft().simplify();
        //simplify right
        Expression right = getRight().simplify();
        //if all numbers evaluate it
        if (left.getClass() == Num.class && right.getClass() == Num.class) {
            try {
                Expression newPow = new Pow(left, right);
                return new Num(newPow.evaluate());
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return new Pow(left.simplify(), right.simplify());
    }
}
