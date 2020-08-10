import java.util.List;
import java.util.Map;

/**
 * Num-  representing numbers.
 */
public class Num implements  Expression {
    private  double num;

    /**
     * Num - constructor.
     * @param num number.
     */
    public Num(double num) {
        this.num = num;
    }


    /**
     * evaluate- A convenience method. Like the `evaluate(assignment)` method above,
     * but uses an empty assignment.
     *
     * @return result.
     * @throws Exception .
     */
    @Override
    public double evaluate() throws Exception {
        return num;
    }

    /**
     * getVariables- returns a list of the variables in the expression.
     *
     * @return null- Num does not contains variables.
     */
    @Override
    public List<String> getVariables() {
        return null;
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
        return this;
    }
    /**
     * toString - a nice string representation of the expression.
     * @return string
     */
    public String toString() {
        return String.valueOf(this.num);
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
        return num;
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
        //the differentiate of a number is a 0
        return new Num(0);
    }
    /**
     * Returned a simplified version of the current expression.
     * @return simplfy expression
     */
    public Expression simplify() {
        return this;
    }
}
