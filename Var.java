import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Var - representing numbers variables.
 */
public class Var implements Expression {
    private String variable;

    /**
     * Var- constructor.
     * @param var variable.
     */
    public Var(String var) {
        this.variable = var;
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
        //if assignment is empty throw exception
        if (assignment == null) {
            throw new RuntimeException("Not all variables are assigned");
        }
        try {
            return assignment.get(this.variable);
        } catch (Exception e) {
            throw new RuntimeException("Not all variables are assigned");
        }
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
        throw new RuntimeException("Not all variables are assigned");
    }

    /**
     * getVariables- returns a list of the variables in the expression.
     *
     * @return list of variables.
     */
    @Override
    public List<String> getVariables() {
        ArrayList<String> list = new ArrayList<String>();
        list.add(variable);
        return list;
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
        //if var is equal to given var return the new expression
        if (var == this.variable) {
            return expression;
        }
        //rerurn the original expression
        return  this;
    }

    /**
     * getVariable- acessor.
     * @return variable.
     */
    public String getVariable() {
        return variable;
    }
    /**
     * toString - a nice string representation of the expression.
     * @return string
     */
    public String toString() {
        return (this.variable);
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
        //check if this is the var the differentiating relate to
        if (this.variable == var) {
            return new Num(1);
        }
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
