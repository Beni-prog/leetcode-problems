package strings;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Problem 14. Longest Common Prefix
 * <p>
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 */
public class LongestCommonPrefix {

    /**
     * This method iterates over the array of string and checks if all the strings are equal to the smallest string.
     * If not, remove the last character from the smallest string and check it against all the strings again. This
     * check is done until the smallest string has no more characters.
     *
     * @param strs an array of strings
     * @return the largest common prefix
     */
    public static String longestCommonPrefix(String[] strs) {
        String smallestString = findMinimumString(strs);

        for (int i = smallestString.length() - 1; i >= 0; i--) {
            for (String str : strs) {
                if (!str.startsWith(smallestString)) {
                    smallestString = smallestString.substring(0, smallestString.length() - 1);
                    break;
                }
            }
        }

        return smallestString;
    }

    /**
     * This method computes the smallest string in regards to the strings size.
     *
     * @param strs an array of strings
     * @return the smallest string in regards to the strings size
     */
    public static String findMinimumString(String[] strs) {
        return Arrays.stream(strs).min(Comparator.comparing(String::length)).get();
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flowers", "flow", "flight", "flavour", "flame"}));//fl
        System.out.println(longestCommonPrefix(new String[]{"flowers", "mouse", "soda"}));//""
        System.out.println(longestCommonPrefix(new String[]{""}));//""
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));//""
    }
}
