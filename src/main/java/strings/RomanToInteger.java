package strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem 13. Roman to Integer
 * <p>
 * Given a roman numeral, convert it to an integer.
 */
public class RomanToInteger {

    /**
     * This method iterates over a string and converts its value into an integer.
     *
     * @param s a roman literal representing an integer number
     * @return the integer value of the roman literal
     */
    public static int romanToInt(String s) {
        Map<String, Integer> pair = new HashMap<>();
        int number = 0;
        int i = s.length() - 1;

        pair.put("M", 1000);
        pair.put("CM", 900);
        pair.put("D", 500);
        pair.put("CD", 400);
        pair.put("C", 100);
        pair.put("XC", 90);
        pair.put("L", 50);
        pair.put("XL", 40);
        pair.put("X", 10);
        pair.put("IX", 9);
        pair.put("V", 5);
        pair.put("IV", 4);
        pair.put("I", 1);

        if (i == 0) {
            return pair.get(s);
        }

        while (i > 0) {
            if ((s.charAt(i - 1) == 'I' && (s.charAt(i) == 'V' || s.charAt(i) == 'X'))
                    || (s.charAt(i - 1) == 'X' && (s.charAt(i) == 'L' || s.charAt(i) == 'C'))
                    || (s.charAt(i - 1) == 'C' && (s.charAt(i) == 'D' || s.charAt(i) == 'M'))) {
                number += pair.get(s.substring(i - 1, i + 1));
                i--;
            } else {
                number += pair.get(s.substring(i, i + 1));
            }
            i--;
            if (i == 0) {
                number += pair.get(s.substring(0, 1));
            }
        }

        return number;
    }


    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));//1994
        System.out.println(romanToInt("LVIII"));//58
        System.out.println(romanToInt("IV"));//4
        System.out.println(romanToInt("D"));//500
    }
}
