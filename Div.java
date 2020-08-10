import java.util.Map;

/**
 * Div- divide the numbers.
 */
public class Div extends BinaryExpression {
    /**
     * Div - devide two expressions.
     *
     * @param leftExp         .
     * @param rightExpression .
     */
    public Div(Expression leftExp, Expression rightExpression) {
        super(leftExp, rightExpression);
    }

    /**
     * BinaryExpression - constructor.
     *
     * @param leftExp         .
     * @param rightExpression .
     */
    public Div(Expression leftExp, double rightExpression) {
        super(leftExp, rightExpression);
    }

    /**
     * BinaryExpression - constructor.
     *
     * @param leftExp         .
     * @param rightExpression .
     */
    public Div(double leftExp, Expression rightExpression) {
        super(leftExp, rightExpression);
    }

    /**
     * BinaryExpression - constructor.
     *
     * @param leftExp         .
     * @param rightExpression .
     */
    public Div(Expression leftExp, String rightExpression) {
        super(leftExp, rightExpression);
    }

    /**
     * BinaryExpression - constructor.
     *
     * @param leftExp         .
     * @param rightExpression .
     */
    public Div(String leftExp, Expression rightExpression) {
        super(leftExp, rightExpression);
    }

    /**
     * BinaryExpression - constructor.
     *
     * @param leftExp         .
     * @param rightExpression .
     */
    public Div(double leftExp, double rightExpression) {
        super(leftExp, rightExpression);
    }

    /**
     * BinaryExpression - constructor.
     *
     * @param leftExp         .
     * @param rightExpression .
     */
    public Div(String leftExp, String rightExpression) {
        super(leftExp, rightExpression);
    }

    /**
     * BinaryExpression - constructor.
     *
     * @param leftExp         .
     * @param rightExpression .
     */
    public Div(double leftExp, String rightExpression) {
        super(leftExp, rightExpression);
    }

    /**
     * BinaryExpression - constructor.
     *
     * @param leftExp         .
     * @param rightExpression .
     */
    public Div(String leftExp, double rightExpression) {
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
        //check devision in 0
        if (getRight().evaluate(assignment) == 0) {
           throw new Exception("Division in 0 is forbidden");
        }
        return (getLeft().evaluate(assignment) / getRight().evaluate(assignment));

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
        return new Div(getLeft().assign(var, expression), getRight().assign(var, expression));
    }

    /**
     * toString - a nice string representation of the expression.
     *
     * @return string
     */
    @Override
    public String toString() {
        return ("(" + getLeft().toString() + " / " + getRight().toString() + ")");
    }

    /**
     * Returns the expression tree resulting from differentiating
     * the current expression relative to variable `var`.
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
        //differentiate by div formoula
        Expression a = new Minus(new Mult(getLeft().differentiate(var), getRight()),
                new Mult(getRight().differentiate(var), getLeft()));
        Expression b = new Pow(getRight(), 2);
        Expression c = new Div(a, b);
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
        //check the case: exp/1
        if (right.getClass() == Num.class) {
            //down cast
            try {
                double num = right.evaluate();
                if (num == 1) {
                    //return the exp
                    return left.simplify();
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        //check the case exp/exp
        //check if vars are equal
        if (left.toString().equals(right.toString())) {
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
        return new Div(left.simplify(), right.simplify());
    }
}
