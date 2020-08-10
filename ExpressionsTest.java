import java.util.Map;
import java.util.TreeMap;

/**
 * ExpressionsTest- run the program.
 */
public class ExpressionsTest {
    /**
     * main- main method, run the program..
     * @param args .
     * @throws Exception
     */
    public static void main(String[] args)  {
        Expression expression = new Plus(new Mult(2, "x"),
                new Plus(new Sin(new Mult(4, "y")), new Pow("e", "x")));
        System.out.println(expression);
        Map<String, Double> assignment = new TreeMap<String, Double>();
        assignment.put("x", 2.0);
        assignment.put("y", 0.25);
        assignment.put("e", 2.71);
        try {
            System.out.println(expression.evaluate(assignment));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(expression.differentiate("x"));
        try {
            System.out.println(expression.differentiate("x").evaluate(assignment));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(expression.differentiate("x").simplify());

    }
}
