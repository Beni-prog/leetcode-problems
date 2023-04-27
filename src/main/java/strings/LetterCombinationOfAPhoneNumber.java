package strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 17. Letter Combinations of a Phone Number
 * <p>
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could
 * represent. Return the answer in any order.
 * <p>
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any
 * letters.
 */
public class LetterCombinationOfAPhoneNumber {

    /**
     * This method computes the combination for digit i and on top of that will build the i+1 combination.
     *
     * @param digits a string representing a number
     * @return all combinations of letters that correspond to the number digits
     */
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.isEmpty()) {
            return result;
        }

        String[] letters = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.add("");

        for (int i = 0; i < digits.length(); i++) {
            int digit = digits.charAt(i) - '0';
            List<String> newCombinations = new ArrayList<>();
            for (String combination : result) {
                for (char letter : letters[digit].toCharArray()) {
                    //add the new characters corresponding to the next digit to the previous combination
                    newCombinations.add(combination + letter);
                }
            }
            //here we keep the last combination
            result = newCombinations;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations("253"));
    }
}
