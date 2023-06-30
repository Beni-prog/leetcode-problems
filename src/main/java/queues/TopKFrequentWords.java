package queues;

import java.util.*;

public class TopKFrequentWords {

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordsFrequency = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (String word : words) {
            wordsFrequency.put(word, wordsFrequency.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue().equals(b.getValue())
                        ? b.getKey().compareTo(a.getKey())
                        : a.getValue() - b.getValue()
        );

        for (Map.Entry entry : wordsFrequency.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            result.add(0, pq.poll().getKey());
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
        System.out.println(topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    }
}
