import java.util.List;
import java.util.ArrayList;

/**
 * BinaryExpression - two expressions for any math operation.
 */
public abstract class BinaryExpression extends BaseExpression {
    private Expression leftExp;
    private  Expression rightExp;
    /**
     * BinaryExpression - constructor.
     * @param leftExp .
     * @param rightExpression .
     */
    public BinaryExpression(Expression leftExp, Expression rightExpression) {
        this.leftExp = leftExp;
        this.rightExp = rightExpression;
    }
    /**
     * BinaryExpression - constructor.
     * @param leftExp .
     * @param rightExpression .
     */
    public BinaryExpression(Expression leftExp, double rightExpression) {
        this.leftExp = leftExp;
        this.rightExp = new Num(rightExpression);
    }
    /**
     * BinaryExpression - constructor.
     * @param leftExp .
     * @param rightExpression .
     */
    public BinaryExpression(double leftExp, Expression rightExpression) {
        this.leftExp = new Num(leftExp);
        this.rightExp = rightExpression;
    }
    /**
     * BinaryExpression - constructor.
     * @param leftExp .
     * @param rightExpression .
     */
    public BinaryExpression(Expression leftExp, String rightExpression) {
        this.leftExp = leftExp;
        this.rightExp = new Var(rightExpression);
    }
    /**
     * BinaryExpression - constructor.
     * @param leftExp .
     * @param rightExpression .
     */
    public BinaryExpression(String leftExp, Expression rightExpression) {
        this.leftExp = new Var(leftExp);
        this.rightExp = rightExpression;
    }
    /**
     * BinaryExpression - constructor.
     * @param leftExp .
     * @param rightExpression .
     */
    public BinaryExpression(double leftExp, double rightExpression) {
        this.leftExp =  new Num(leftExp);
        this.rightExp = new Num(rightExpression);
    }
    /**
     * BinaryExpression - constructor.
     * @param leftExp .
     * @param rightExpression .
     */
    public BinaryExpression(String leftExp, String rightExpression) {
        this.leftExp = new Var(leftExp);
        this.rightExp = new Var(rightExpression);
    }
    /**
     * BinaryExpression - constructor.
     * @param leftExp .
     * @param rightExpression .
     */
    public BinaryExpression(double leftExp, String rightExpression) {
        this.leftExp = new Num(leftExp);
        this.rightExp = new Var(rightExpression);
    }
    /**
     * BinaryExpression - constructor.
     * @param leftExp .
     * @param rightExpression .
     */
    public BinaryExpression(String leftExp, double rightExpression) {
        this.leftExp = new Var(leftExp);
        this.rightExp = new Num(rightExpression);
    }
    /**
     * getVariables- returns a list of the variables in the expression.
     * @return list of variables.
     */
    public List<String> getVariables() {
        //add to sub lists
        ArrayList<String> variables = new ArrayList<String>();
        if (leftExp.getVariables() != null) {
            //get variables from left
            variables.addAll(leftExp.getVariables());
        }
        if (rightExp.getVariables() != null) {
            //get variables from right
            variables.addAll(rightExp.getVariables());
        }
        //remove duplicates
        variables = removeDuplicates(variables);
        return variables;
    }

    /**
     * getLeft- acessor.
     * @return left expression.
     */
    public Expression getLeft() {
        return leftExp;
    }
    /**
     * getRight- acessor.
     * @return right expression.
     */
    public Expression getRight() {
        return rightExp;
    }
}
