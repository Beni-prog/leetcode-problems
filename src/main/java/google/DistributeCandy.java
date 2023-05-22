package google;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandy {
    public static int distributeCandies(int[] candyType) {
        Set<Integer> uniqueCandies = new HashSet<>();

        for (int candy : candyType) {
            uniqueCandies.add(candy);
        }

        return Math.min(candyType.length / 2, uniqueCandies.size());
    }

    public static void main(String[] args) {
        System.out.println(distributeCandies(new int[]{1, 1, 2, 2, 3, 3}));
        System.out.println(distributeCandies(new int[]{1, 1, 2, 2, 3, 3, 3, 4, 4, 5}));
        System.out.println(distributeCandies(new int[]{1, 1, 2, 2, 3, 3}));
    }
}
