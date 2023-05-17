package google;

import java.util.ArrayList;
import java.util.List;

/**
 * First, design a way to return true if a given sequence of words is a word square.
 * <p>
 * Second, given an arbitrary list of words, return all the possible word squares it contains. Reordering is allowed.
 * <p>
 * For example, the input list
 * <p>
 * [AREA, BALL, DEAR, LADY, LEAD, YARD]
 * <p>
 * should output
 * <p>
 * [(BALL, AREA, LEAD, LADY), (LADY, AREA, DEAR, YARD)]
 */
public class WordSquares {

    /**
     * This method checks if an array of strings is word sequence or not.
     *
     * @param words an array of strings
     * @return true if the given array is a word sequence or false otherwise.
     */
    static boolean isWordSquare(String[] words) {
        int length = words[0].length();
        char[][] matrix = new char[length][length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                matrix[i][j] = words[i].charAt(j);
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * This method finds all the word squares from an array of strings
     *
     * @param words an array of strings that represent words
     * @return a list of word squares
     */
    public static List<List<String>> findWordSquares(String[] words) {
        List<List<String>> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return result;
        }

        int len = words[0].length();
        List<String> wordSquare = new ArrayList<>();
        backtrack(words, len, 0, wordSquare, result);

        return result;
    }

    /**
     * This method generates all possible word sequences from an array of strings, using backtracking.
     *
     * @param words      an array of strings, that represent words
     * @param len        the length of each word
     * @param row        a counter that is increased till length
     * @param wordSquare a list of strings
     * @param result     a list of lists of strings that represents all the word squares
     */
    private static void backtrack(String[] words, int len, int row, List<String> wordSquare, List<List<String>> result) {
        if (row == len) {
            // Check if the word square is valid using the existing isWordSquare method
            if (isWordSquare(wordSquare.toArray(new String[0]))) {
                // Found a valid word square, add it to the result
                result.add(new ArrayList<>(wordSquare));
            }
            return;
        }

        for (String word : words) {
            wordSquare.add(word);
            // Move to the next row in the word square
            backtrack(words, len, row + 1, wordSquare, result);
            // Remove the last word to backtrack and try other words
            wordSquare.remove(wordSquare.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(isWordSquare(new String[]{"DOG", "ORA", "GAY"}));
        System.out.println(isWordSquare(new String[]{"BALL", "AREA", "LEAD", "LADY"}));

        System.out.println(findWordSquares(new String[]{"AREA", "BALL", "DEAR", "LADY", "LEAD", "YARD"}));
    }
}
