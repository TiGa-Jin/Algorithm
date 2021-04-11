package everyday;

import java.lang.reflect.Array;
import java.util.Arrays;

public class No706 {
    int[][] map = new int[1000000][2];

    /** Initialize your data structure here. */
    public No706() {
        for (int i = 0; i < 1000000; i++) {
            Arrays.fill(map[i], -1);

        }

    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        map[key][1] = value;

    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return map[key][1];

    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
      map[key][1] = -1;
    }

    public static void main(String[] args) {
        No706 obj = new No706();
        int key = 2;
        int value = 3;

        obj.put(key,value);
        int param_2 = obj.get(key);
        obj.remove(key);



    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */