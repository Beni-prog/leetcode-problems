package strings;

/**
 * Problem 6. Zigzag Conversion
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows
 */
public class ZigZagConversionImproved {

    /**
     * It first checks if numRows is equal to 1, and if so, it returns the input string s unchanged. It then initializes a StringBuilder to construct the result
     * string and computes the length of each cycle (denoted as cycleLen).
     * <p>
     * The method then iterates over each row (denoted as i) and each cycle (denoted as j). For each row and cycle, it appends the character at the current
     * index j + i to the StringBuilder. If i is not the first or last row and the character at index j + cycleLen - i is within the bounds of the input string s,
     * it also appends this character to the StringBuilder.
     * <p>
     * Finally, the method returns the resulting string from the StringBuilder.
     *
     * @param s       the string
     * @param numRows number of rows we want to display the string on
     * @return the order the string is read from left to right.
     */
    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder sb = new StringBuilder();
        int cycleLen = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < s.length(); j += cycleLen) {
                sb.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < s.length())
                    sb.append(s.charAt(j + cycleLen - i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));
    }
}
