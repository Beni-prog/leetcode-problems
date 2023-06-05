package strings;

import java.util.HashMap;

public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {

        HashMap<Character, Character> sToT = new HashMap<>();
        HashMap<Character, Character> tToS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // Check if the mapping between c1 and c2 exists in both maps
            if (sToT.containsKey(c1) && sToT.get(c1) != c2 ||
                    tToS.containsKey(c2) && tToS.get(c2) != c1) {
                return false;
            }

            // Create the mapping between c1 and c2 in both maps
            sToT.put(c1, c2);
            tToS.put(c2, c1);
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("egg", "foo"));
        System.out.println(isIsomorphic("egg", "bar"));
        System.out.println(isIsomorphic("pepper", "lillin"));
        System.out.println(isIsomorphic("bbbaaaba", "aaabbbba"));
    }
}
