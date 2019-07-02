package arrays;

import java.util.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.stream.Collectors.*;
import static java.util.Map.Entry.*;

public class SortCharByFreq {

    public static void main(String[] ar) {
        String s = "cccaaa";
        System.out.println(doSortCharByFreq(s));
    }

    static String doSortCharByFreq(String s) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                int value = map.get(s.charAt(i));
                value = value + 1;
                map.put(s.charAt(i), (Integer) value);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        map = sortReverse(map);
        for (Map.Entry<Character, Integer> entry : map.entrySet())
            for (Integer i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        return sb.toString();
    }

    static HashMap<Character, Integer> sortReverse(HashMap<Character, Integer> map) {
        List<Map.Entry<Character, Integer>> list = new LinkedList<Map.Entry<Character, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        HashMap<Character, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> aa : list)
         {
             sortedMap.put(aa.getKey(),aa.getValue());

         }
        return sortedMap;

    }


}
