package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindReplacePattern {

    public static  void main(String[] args) {
        String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
        //String[] words = {"ccc"};
        String pattern = "abb";
        List<String> foundWords = new ArrayList<>();
        for (String w : words) {
            if (patternFound(w,pattern)) {
                foundWords.add(w);
            }
        }
        System.out.println(foundWords.toString());

    }

    static  boolean patternFound(String word,String pattern) {
        boolean found = false;
        int count = 0;
        Map<Character,Character> map = new HashMap<>();
        for (int i =0;i<pattern.length();i++) {
            Character key = new Character(pattern.charAt(i));
            Character value = new Character(word.charAt(i));
            if (!(map.containsKey(key)) && !map.containsValue(value)) {
                map.put(key,value);
                count++;
            } else {
                if (map.containsKey(key)) {
                    if (!(map.get(key).equals(value))) {
                        break;
                    } else {
                        count++;
                    }
                }

            }
        }
        if (count == pattern.length()) {
            found = true;
        }
        return found;
    }
}
