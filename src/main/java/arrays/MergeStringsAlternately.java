package arrays;

/**
 * Problem 1768. Merge Strings Alternately
 * <p>
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with
 * word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
 * <p>
 * Return the merged string.
 */
public class MergeStringsAlternately {

    /**
     * This method iterates the 2 string and forms a new one, by alternately adding one character from each string.
     *
     * @param word1 the first string
     * @param word2 the second string
     * @return a new string that is formed by alternately merging the first two strings
     */
    public static String mergeAlternately(String word1, String word2) {
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();

        while (i < word1.length() && j < word2.length()) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(j));
            i++;
            j++;
        }

        while (i < word1.length()) {
            sb.append(word1.charAt(i));
            i++;
        }

        while (j < word2.length()) {
            sb.append(word2.charAt(j));
            j++;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(mergeAlternately("ace", "bdf"));
        System.out.println(mergeAlternately("ab", "pqrs"));
        System.out.println(mergeAlternately("Lecd", "etoe!!!"));
    }
}
