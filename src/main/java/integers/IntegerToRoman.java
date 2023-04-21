package integers;

/**
 * Problem 12. Integer to Roman
 * <p>
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
 * Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same
 * principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * <p>
 * Given an integer, convert it to a roman numeral.
 */
public class IntegerToRoman {

    /**
     * We iterate over the values array, starting from the highest value and moving down. At each step, we check if
     * the current value is less than or equal to the remaining number to convert. If it is, we subtract the value from
     * the number and append the corresponding symbol to a StringBuilder. We repeat this process until the number is
     * reduced to zero.
     *
     * @param num an integer number
     * @return the integer number converted in roman letters
     */
    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < 13; i++) {
            while (num >= values[i]) {
                sb.append(symbols[i]);
                num -= values[i];
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(19));//XIX
        System.out.println(intToRoman(34));//XXXIV
        System.out.println(intToRoman(49));//XLIX
        System.out.println(intToRoman(58));//LVIII
        System.out.println(intToRoman(1995));//MCMXCV
    }
}
