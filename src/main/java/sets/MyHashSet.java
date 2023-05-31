package sets;

import java.util.ArrayList;
import java.util.List;

public class MyHashSet {
    private final int bucketSize = 1000;
    //the hash table will be a list of buckets (bucket = list)
    private final List<List<Integer>> buckets;

    public MyHashSet() {
        buckets = new ArrayList<>(bucketSize);
        for (int i = 0; i < bucketSize; i++) {
            buckets.add(null);
        }
    }

    public void add(int key) {
        //get the index of this key
        int bucketIndex = getBucketIndex(key);
        //get the list at this index
        List<Integer> bucket = buckets.get(bucketIndex);
        //if the bucket is null, create a new array list
        // and add to the hash table
        if (bucket == null) {
            bucket = new ArrayList<>();
            buckets.set(bucketIndex, bucket);
        }
        //check id the key already exists, if not, add it to the bucket
        if (!bucket.contains(key)) {
            bucket.add(key);
        }
    }

    public boolean contains(int key) {
        int bucketIndex = getBucketIndex(key);
        List<Integer> bucket = buckets.get(bucketIndex);
        return bucket != null && bucket.contains(key);
    }

    public void remove(int key) {
        int bucketIndex = getBucketIndex(key);
        List<Integer> bucket = buckets.get(bucketIndex);
        if (bucket != null) {
            bucket.remove(Integer.valueOf(key));
        }
    }

    //this is the hash function
    private int getBucketIndex(int key) {
        return key % bucketSize;
    }

    public static void main(String[] args) {
        MyHashSet obj = new MyHashSet();
        obj.add(1);
        boolean param1 = obj.contains(1);
        System.out.println(param1);
        obj.remove(1);
        boolean param2 = obj.contains(1);
        System.out.println(param2);
    }
}
