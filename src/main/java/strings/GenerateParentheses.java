package strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 22. Generate Parentheses
 * <p>
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
public class GenerateParentheses {

    /**
     * This method receives a number n and returns a list of valid parentheses pairs permutations.
     *
     * @param n the number of parentheses pair
     * @return a list of strings, representing the all valid parentheses pairs permutations
     */
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        return generateParenthesis(n, 0, 0, "", ans);
    }

    /**
     * This method computes recursively all the valid parentheses pair permutations.
     *
     * @param n     the number of valid parentheses
     * @param open  the number of open parentheses added in the string so far
     * @param close the number of close parentheses added in the string so far
     * @param s     the string used to build the permutations
     * @param ans   the list of total valid parentheses pair permutations
     * @return the list of total valid parentheses pair permutations
     */
    public static List<String> generateParenthesis(int n, int open, int close, String s, List<String> ans) {

        // if the count of both open and close parentheses
        // reaches n, it means we have generated a valid
        // parentheses. So, we add the currently generated
        // string s to the final ans and return.
        if (open == n && close == n) {
            ans.add(s);
            return ans;
        }

        // At any index i in the generation of the string s,
        // we can put an open parentheses only if its count
        // until that time is less than n.
        if (open < n) {
            ans = generateParenthesis(n, open + 1, close, s + "(", ans);
        }

        // At any index i in the generation of the string s,
        // we can put a closed parentheses only if its count
        // until that time is less than the count of open
        // parentheses.
        if (close < open) {
            ans = generateParenthesis(n, open, close + 1, s + ")", ans);
        }

        return ans;
    }

    public static void main(String[] args) {

        System.out.println(generateParenthesis(3));
    }
}
