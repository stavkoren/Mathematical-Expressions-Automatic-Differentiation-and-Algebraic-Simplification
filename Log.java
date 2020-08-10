import java.util.Map;

/**
 * Log - log two expressions.
 */
public class Log extends BinaryExpression {
    /**
     * Plus - add two expressions.
     *
     * @param leftExp         .
     * @param rightExpression .
     */
    public Log(Expression leftExp, Expression rightExpression) {
        super(leftExp, rightExpression);
    }

    /**
     * BinaryExpression - constructor.
     *
     * @param leftExp         .
     * @param rightExpression .
     */
    public Log(Expression leftExp, double rightExpression) {
        super(leftExp, rightExpression);
    }

    /**
     * BinaryExpression - constructor.
     *
     * @param leftExp         .
     * @param rightExpression .
     */
    public Log(double leftExp, Expression rightExpression) {
        super(leftExp, rightExpression);
    }

    /**
     * BinaryExpression - constructor.
     *
     * @param leftExp         .
     * @param rightExpression .
     */
    public Log(Expression leftExp, String rightExpression) {
        super(leftExp, rightExpression);
    }

    /**
     * BinaryExpression - constructor.
     *
     * @param leftExp         .
     * @param rightExpression .
     */
    public Log(String leftExp, Expression rightExpression) {
        super(leftExp, rightExpression);
    }

    /**
     * BinaryExpression - constructor.
     *
     * @param leftExp         .
     * @param rightExpression .
     */
    public Log(double leftExp, double rightExpression) {
        super(leftExp, rightExpression);
    }

    /**
     * BinaryExpression - constructor.
     *
     * @param leftExp         .
     * @param rightExpression .
     */
    public Log(String leftExp, String rightExpression) {
        super(leftExp, rightExpression);
    }

    /**
     * BinaryExpression - constructor.
     *
     * @param leftExp         .
     * @param rightExpression .
     */
    public Log(double leftExp, String rightExpression) {
        super(leftExp, rightExpression);
    }

    /**
     * BinaryExpression - constructor.
     *
     * @param leftExp         .
     * @param rightExpression .
     */
    public Log(String leftExp, double rightExpression) {
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
        //make sure the base is bigger then 0 and not equal to 1 and num >0
        if (getLeft().evaluate(assignment) <= 0 && getLeft().evaluate(assignment) != 1
                && getRight().evaluate(assignment) > 0) {
            throw new Exception("Log error");
        }
        double rightSide = Math.log(getRight().evaluate(assignment));
        double leftSide = Math.log(getLeft().evaluate(assignment));
        return rightSide / leftSide;
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
        return new Log(getLeft().assign(var, expression), getRight().assign(var, expression));
    }

    /**
     * toString - a nice string representation of the expression.
     *
     * @return string
     */
    @Override
    public String toString() {
        return ("log(" + getLeft().toString() + ", " + getRight().toString() + ")");
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
        Expression a = new Mult(getRight(), new Log("e", getLeft()));
        return new Div(getRight().differentiate(var), a);
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
            //check the case of exp,exp
            if (left.toString().equals(right.toString())) {
                //the expressions are equal
                return new Num(1);
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
            return new Log(left.simplify(), right.simplify());
        }
    }
