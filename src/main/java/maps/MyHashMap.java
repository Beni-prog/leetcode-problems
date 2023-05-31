package maps;

public class MyHashMap {

    private int size = 1000001;
    private final int[] map;

    public MyHashMap() {
        map = new int[size];
        for (int i = 0; i < size; i++) {
            map[i] = -1;
        }
    }

    public void put(int key, int value) {
        map[key] = value;
    }

    public int get(int key) {
        return map[key];
    }

    public void remove(int key) {
        map[key] = -1;
    }

    public static void main(String[] args) {
        MyHashMap obj = new MyHashMap();
        obj.put(1, 10);
        int param_2 = obj.get(1);
        System.out.println(param_2);
        obj.remove(1);
        System.out.println(obj.get(1));
    }
}
