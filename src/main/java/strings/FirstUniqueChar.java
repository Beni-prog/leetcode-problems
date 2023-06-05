package strings;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueChar {

    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.replace(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));//0
        System.out.println(firstUniqChar("loveleetcode"));//2
        System.out.println(firstUniqChar("aabb"));//-1
    }
}
