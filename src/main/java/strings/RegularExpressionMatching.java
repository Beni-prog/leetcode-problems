package strings;

/**
 * Problem 10. Regular Expression Matching
 * <p>
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 */
public class RegularExpressionMatching {

    /**
     * To implement regular expression matching with support for '.' and '*', we can use dynamic programming.
     * We will create a 2D boolean array dp where dp[i][j] will be true if the first i characters of s match the first j
     * characters of p, and false otherwise. After filling in the dp array, the result will be in dp[s.length()][p.length()].
     * If this is true, then the entire input string matches the pattern, and we can return true. Otherwise, we return false.
     *
     * @param s the string we must check
     * @param p the pattern we check the string against
     * @return true, if the string matches tha pattern p, false otherwise
     */
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //the current characters match, and we can just use the previous result
                if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    //we can ignore the preceding character, char before * repeats 0 times
                    dp[i][j] = dp[i][j - 2];
                    //if s[i] matches the preceding element in the pattern || does not match
                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    //otherwise, characters do not match
                    dp[i][j] = false;
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println("Should output false: " + isMatch("abab", "ab*"));
        System.out.println("Should output false: " + isMatch("aa", "a"));
        System.out.println("Should output true: " + isMatch("aabcdbcd", ".*"));
        System.out.println("Should output true: " + isMatch("bbb", "b*"));
        System.out.println("Should output false: " + isMatch("bbbeee", "b*"));
        System.out.println("Should output false: " + isMatch("bcdef", "bcd"));
        System.out.println("Should output true: " + isMatch("bcd", "bcd"));
        System.out.println("Should output true: " + isMatch("aab", "c*a*b"));
        System.out.println("Should output true: " + isMatch("mississippi", "mis*is*ip*i"));
        System.out.println("Should output true: " + isMatch("mississippi", "mis*is*ip*."));
        System.out.println("Should output true: " + isMatch("dda", "c*d*a"));
    }
}
