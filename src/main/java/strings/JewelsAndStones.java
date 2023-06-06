package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JewelsAndStones {

    public static int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> jMap = new HashMap<>();

        for (int i = 0; i< jewels.length(); i++) {
            jMap.put(jewels.charAt(i), 0);
        }

        for (int i = 0; i < stones.length(); i++) {
            if (jMap.containsKey(stones.charAt(i))) {
                jMap.put(stones.charAt(i), jMap.get(stones.charAt(i)) + 1);
            }
        }

        List<Integer> values = new ArrayList<>(jMap.values());
        int sum = 0;
        for (Integer integer: values) {
            sum += integer;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(numJewelsInStones("z", "ZZ"));
    }
}
