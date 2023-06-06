package maps;

import java.util.*;
import java.util.stream.Collectors;

public class RandomizedSet {

    Map<Integer, Integer> map = new HashMap<>();

    public RandomizedSet() {
    }

    public boolean insert(int val) {
        if (map.getOrDefault(val, 0) == 0) {
            map.put(val, 1);
            return true;
        }

        return false;
    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            map.remove(val);
            return true;
        }

        return false;
    }

    public int getRandom() {
        List<Map.Entry<Integer, Integer>> filteredList = new ArrayList<>(map.entrySet());
        filteredList = filteredList.stream().filter((Map.Entry entry) -> entry.getValue() != null).collect(Collectors.toList());
        int randomNumber = new Random().nextInt(filteredList.size());
        return filteredList.get(randomNumber).getKey();
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1)); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        System.out.println(randomizedSet.remove(2)); // Returns false as 2 does not exist in the set.
        System.out.println(randomizedSet.insert(2)); // Inserts 2 to the set, returns true. Set now contains [1,2].
        System.out.println(randomizedSet.getRandom()); // getRandom() should return either 1 or 2 randomly.
        System.out.println(randomizedSet.remove(1)); // Removes 1 from the set, returns true. Set now contains [2].
        System.out.println(randomizedSet.insert(2)); // 2 was already in the set, so return false.
        System.out.println(randomizedSet.getRandom()); // Since 2 is the only number in the set, getRandom() will always return 2.
    }
}
