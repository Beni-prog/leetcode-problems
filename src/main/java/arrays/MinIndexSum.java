package arrays;

import java.util.*;

public class MinIndexSum {

    public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> common = new HashSet<>();

        int minIndexSum = Integer.MAX_VALUE;

        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        for (int j = 0; j < list2.length; j++) {
            //if we find a common string
            if (map.containsKey(list2[j])) {
                //then compute the index sum and the min index sum
                int indexSum = j + map.get(list2[j]);

                //if we find another min, reset the hashset and the min index sum
                if (indexSum < minIndexSum) {
                    common.clear();
                    common.add(list2[j]);
                    minIndexSum = indexSum;
                } else if (indexSum == minIndexSum) {
                    common.add(list2[j]);
                }
            }
        }

        return common.toArray(new String[0]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRestaurant(new String[]{"happy", "sad", "good"}, new String[]{"sad", "happy", "good"})));
        System.out.println(Arrays.toString(findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"KFC", "Shogun", "Burger King"})));
        System.out.println(Arrays.toString(findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"})));
    }
}
