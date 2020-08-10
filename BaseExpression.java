import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * BaseExpression - contains methods which are the same for all classes.
 */
public abstract class BaseExpression implements Expression {
    /**
     * removeDuplicates - remove duplicates in a list.
     * @param list .
     * @return list .
     */
    public ArrayList<String> removeDuplicates(ArrayList<String> list) {
        //using set which forbid duplicates
        Set<String> hs = new HashSet<>();
        hs.addAll(list);
        list.clear();
        list.addAll(hs);
        return  list;
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
        //call the other evaluate
        return this.evaluate(null);
    }
}
