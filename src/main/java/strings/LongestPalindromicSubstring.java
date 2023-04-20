package strings;

/**
 * Problem 5. Longest Palindromic Substring
 * <p>
 * Given a string s, return the longest palindromic substring in s.
 */
public class LongestPalindromicSubstring {

    /**
     * Use a 2D array (matrix) in order to mark the palindromic substrings (if a substring starting at i and ending at j
     * is palindromic, then we set the location at (i,j) to true.
     * <p>
     * Set the main diagonal of the matrix to true (every single char is palindromic).
     * <p>
     * Iterate from 0 to j each time to look for new possible palindromic substrings.
     * <p>
     * Then, there are 3 conditions for checking if a new substring is palindromic:
     * <p>
     * check id the substring starts and ends with the same char
     * check if the substring has 3 chars - it is definitely palindromic
     * if it has more than 3 chars, check if the inner substring was previously marked as palindromic
     * If true, then set the substring as palindromic.
     *
     * @param s the string
     * @return the longest palindromic substring
     */
    public static String longestPalindrome(String s) {
        int longestSoFar = 0, startIndex = 0, endIndex = 0;
        boolean[][] palindrome = new boolean[s.length()][s.length()];

        for (int j = 0; j < s.length(); j++) {
            //set the main diagonal of the matrix to true
            palindrome[j][j] = true;
            //iterate from 0 to j
            for (int i = 0; i < j; i++) {
                //1. check id the substring starts and ends with the same char
                //2. check if the substring has 3 chars - it is definitely palindromic
                //3. if has more than 3 chars, check is the inner substring was previously marked as palindromic
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || palindrome[i + 1][j - 1])) {
                    //set the substring as palindromic
                    palindrome[i][j] = true;
                    if (j - i + 1 > longestSoFar) {
                        longestSoFar = j - i + 1;
                        startIndex = i;
                        endIndex = j;
                    }
                }
            }
        }

        return s.substring(startIndex, endIndex + 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babadb"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("cbbdbbceeffrffee"));
    }
}
