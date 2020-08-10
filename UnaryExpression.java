import java.util.ArrayList;
import java.util.List;

/**
 * UnaryExpression - only have one expression for math operations.
 */
public abstract class UnaryExpression extends BaseExpression {
    private Expression nextExp;

    /**
     * UnaryExpression - constructor.
     * @param expression .
     */
    public UnaryExpression(Expression expression) {

        this.nextExp = expression;
    }
    /**
     * UnaryExpression - constructor.
     * @param expression .
     */
    public UnaryExpression(double expression) {
        this.nextExp = new Num(expression);
    }
    /**
     * UnaryExpression - constructor.
     * @param expression .
     */
    public UnaryExpression(String expression) {
        this.nextExp = new Var(expression);
    }
    /**
     * getVariables- returns a list of the variables in the expression.
     * @return list of variables.
     */
    public List<String> getVariables() {
        //add to sub lists
        ArrayList<String> variables = new ArrayList<String>();
        if (nextExp.getVariables() != null) {
            //get variables from left
            variables.addAll(nextExp.getVariables());
        }
        //remove duplicates
        variables = removeDuplicates(variables);
        return variables;
    }

    /**
     * getNextExp- accessor.
     * @return expression.
     */
    public Expression getNextExp() {
        return nextExp;
    }
}
