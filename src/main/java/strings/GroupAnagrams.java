package strings;

import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String string : strs) {

            //sort the string
            char[] tempArray = string.toCharArray();
            Arrays.sort(tempArray);
            String sortedString = new String(tempArray);

            if (map.containsKey(sortedString)) {
                //get the existing list
                map.get(sortedString).add(string);
            } else {
                //or construct a list mapped to this new string key
                map.put(sortedString, new ArrayList<>(Collections.singleton(string)));
            }
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(groupAnagrams(new String[]{""}));
        System.out.println(groupAnagrams(new String[]{"a"}));
    }
}
