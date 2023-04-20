package strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem 3. Longest Substring Without Repeating Characters
 * <p>
 * Given a string s, find the length of the longest
 * substring without repeating characters.
 */
public class NonRepeatingCharacters {

    /**
     * Compute the longest subsequence of unique chars
     *
     * @param s a string
     * @return the length of the longest subsequence of unique chars
     */
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> pair = new HashMap<>();

        int k = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            //keep in a map all the pairs (character, index), as long as there is no repeating char
            //also, count (k) all the unique chars and compute the maximum of k
            if (!pair.containsKey(s.charAt(i))) {
                pair.put(s.charAt(i), i);
                k++;
                max = Math.max(max, k);
            } else {
                //if a repeating char was found, reset the counter, the index i and the map and start over
                k = 0;
                i = pair.get(s.charAt(i));
                pair.clear();
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("bbbb"));
        System.out.println(lengthOfLongestSubstring("aab"));
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }
}
