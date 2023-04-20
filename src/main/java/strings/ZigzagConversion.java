package strings;

/**
 * Problem 6. Zigzag Conversion
 * <p>
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * <p>
 * And then read line by line: "PAHNAPLSIIGYIR"
 */
public class ZigzagConversion {

    /**
     * It first checks if numRows is equal to 1, and if so, it returns the input string s unchanged. It then initializes
     * a StringBuilder to construct the result string and computes the length of each cycle (denoted as cycleLen).
     * <p>
     * The method then iterates over each row (denoted as i) and each cycle (denoted as j). For each row and cycle,
     * it appends the character at the current index j + i to the StringBuilder. If i is not the first or last row and
     * the character at index j + cycleLen - i is within the bounds of the input string s, it also appends this character
     * to the StringBuilder.
     * <p>
     * Finally, the method returns the resulting string from the StringBuilder.
     *
     * @param s       the string
     * @param numRows on how many rows we want to display the string
     * @return the string read in zigzag
     */
    public static String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        int pace = numRows + (numRows - 2);
        int increment;
        int i = 0;
        boolean mustChangeFrequency = false;

        while (i < numRows) {
            if (pace == 0) {
                pace = numRows + (numRows - 2);
            }
            increment = i;
            while (increment < s.length()) {
                if (i != numRows - 1 && i % 2 == 1) {
                    sb.append(s.charAt(increment));
                    if (mustChangeFrequency) {
                        increment += numRows + (numRows - 2) - pace;
                        mustChangeFrequency = false;
                    } else {
                        increment += pace;
                        mustChangeFrequency = true;
                    }

                } else if (i != 0 && i != numRows - 1 && i % 2 == 0) {
                    sb.append(s.charAt(increment));
                    if (mustChangeFrequency) {
                        increment += pace;
                        mustChangeFrequency = false;
                    } else {
                        increment += numRows + (numRows - 2) - pace;
                        mustChangeFrequency = true;
                    }
                } else {
                    sb.append(s.charAt(increment));
                    increment += pace;
                }
            }
            i++;
            pace -= 2;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));
        System.out.println(convert("MAMA", 2));
    }
}
