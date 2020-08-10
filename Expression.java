import java.util.List;
import java.util.Map;

/**
 * Expression - represent mathematical expressions.
 */
public interface Expression {
    /**
     * Evaluate the expression using the variable values provided
     * in the assignment, and return the result.  If the expression
     * contains a variable which is not in the assignment, an exception
     *  is thrown.
     * @param assignment .
     * @return result .
     * @throws Exception if the expression contains a variable which is not in the assignment.
     */
    double evaluate(Map<String, Double> assignment) throws Exception;
    /**
     * evaluate- A convenience method. Like the `evaluate(assignment)` method above,
     * but uses an empty assignment.
     * @return result.
     * @throws Exception .
     */
    double evaluate() throws Exception;
    /**
     * getVariables- returns a list of the variables in the expression.
     * @return list af all variables.
     */
    List<String> getVariables();
    /**
     * toString - a nice string representation of the expression.
     * @return string
     */
    String toString();

    // Returns a new expression in which all occurrences of the variable
    // var are replaced with the provided expression (Does not modify the
    // current expression).

    /**
     * assign - Returns a new expression in which all occurrences of the variable
     * ar are replaced with the provided expression (Does not modify the
     * current expression).
     * @param var .
     * @param expression .
     * @return new expression.
     */
    Expression assign(String var, Expression expression);
    /**
     * Returns the expression tree resulting from differentiating
     * the current expression relative to variable `var`.
     * @param var .
     * @return the differentiate of the expression.
     */
    Expression differentiate(String var);

    /**
     * Returned a simplified version of the current expression.
     * @return simplfy expression
     */
    Expression simplify();
}
