package utils;

import java.util.Map;

/**
 * This is a utility class.
 */
public class Utils {

    /**
     * This method is used to display a map.
     *
     * @param map a map
     */
    public static void displayMap(Map<Integer, Integer> map) {
        for (Map.Entry entry : map.entrySet()) {
            System.out.println("Pair: (" + entry.getKey() + ", " + entry.getValue() + ")");
        }
    }
}
