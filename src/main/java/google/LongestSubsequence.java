package google;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Longest subsequence
 * <p>
 * Given a string S and a set of words D, find the longest word in D that is a subsequence of S.
 * <p>
 * Word W is a subsequence of S if some number of characters, possibly zero, can be deleted from S to form W, without
 * reordering the remaining characters.
 * <p>
 * Note: D can appear in any format (list, hash table, prefix tree, etc.
 * <p>
 * For example, given the input of S = "abppplee" and D = {"able", "ale", "apple", "bale", "kangaroo"} the correct
 * output would be "apple"
 */
public class LongestSubsequence {

    /**
     * @param set a set of strings
     * @param s   a string
     * @return the longest subsequence which can be formed from the letters of string s, having the same order of letters
     */
    public static String longestSubsequence(Set<String> set, String s) {
        int max = 0;
        int count;
        String longestString = "";

        int i, j, k;
        for (String string : set) {
            if (string.length() > s.length()) {
                continue;
            }
            count = 0;
            i = 0;
            j = 0;
            k = 0;
            while (k < string.length() && i < string.length() && j < s.length()) {
                while (i < string.length() && s.charAt(j) == string.charAt(i)) {
                    i++;
                    j++;
                    count++;
                }
                while (i < string.length() && j < s.length() && s.charAt(j) != string.charAt(i)) {
                    j++;
                }
                k++;
            }
            if (count > max) {
                max = count;
                longestString = string;
            }
        }

        return longestString;
    }

    public static void main(String[] args) {
        System.out.println(longestSubsequence(new HashSet<>(Arrays.asList("able", "ale", "apple", "bale", "abpple", "abppplee", "abpppleee", "abpppleeee")), "abpppleee"));
        System.out.println(longestSubsequence(new HashSet<>(Collections.singletonList("abpppleeee")), "abpppleee"));
        System.out.println(longestSubsequence(new HashSet<>(Collections.singletonList("")), "abpppleee"));
    }
}
