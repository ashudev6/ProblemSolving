package bonus;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.*;

public class LRUCache {

    static HashMap<Integer, Integer> map;
    int CAPACITY = 0;
    static HashMap<Integer, Long> helperMap;

    public LRUCache(int capacity) {
        CAPACITY = capacity;
        map = new HashMap<>(CAPACITY);
        helperMap = new HashMap<>(CAPACITY);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int value = map.get(key);
            if (helperMap.containsKey(key)) {
                helperMap.put(key, getTimeStamp());
            }
            return value;
        }
        return -1;

    }

    long getTimeStamp() {
        return System.nanoTime();
    }

    HashMap<Integer, Long> sortMap(HashMap<Integer, Long> map) {
        List<Map.Entry<Integer, Long>> list = new LinkedList<Map.Entry<Integer, Long>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Long>>() {
            @Override
            public int compare(Map.Entry<Integer, Long> o1, Map.Entry<Integer, Long> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        HashMap<Integer, Long> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Long> e : list) {
            sortedMap.put(e.getKey(), e.getValue());
        }
        return sortedMap;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            helperMap.put(key, getTimeStamp());
        } else {
            if (map.size() == CAPACITY) {
                helperMap = sortMap(helperMap);
                int oldKey = 0;
                for (Integer i : helperMap.keySet()) {
                    oldKey = i;
                    break;
                }
                if (map.containsKey(oldKey)) {
                    map.remove(oldKey);
                    helperMap.remove(oldKey);
                }
            }
            map.put(key, value);
            helperMap.put(key, getTimeStamp());
        }

    }

    public static void main(String[] ar) {
        LRUCache lruCache = new LRUCache(5);
        for (int i = 0; i < 5; i++) {
            lruCache.put(i, i + 5);
        }
        System.out.println(map);
        System.out.println(lruCache.helperMap);
        System.out.println(lruCache.get(0));
        //helperMap = lruCache.sortMap(helperMap);
        //System.out.println(lruCache.helperMap);
        lruCache.put(6, 11);
        System.out.println(lruCache.helperMap);
        System.out.println(map);
        System.out.println(lruCache.get(4));
        lruCache.put(7, 12);
        System.out.println(map);
    }
}
