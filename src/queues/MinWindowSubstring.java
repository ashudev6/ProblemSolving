package queues;

import java.util.*;

public class MinWindowSubstring {

    public static void main(String[] ar) {
//        "aaaaaaaaaaaabbbbbcdd"
//        "abcdd"

//        "cabefgecdaecf"
//        "cae"
        String s = "cabefgecdaecf";
        //String s = "ADOBECODEBANC";
        String t = "cae";
        //t = "ashu";
        //System.out.println(t);
        System.out.println("value: " + minWindow1(s, t));
    }

    public static String minWindow1(String s, String t) {
        if (s.length() == t.length()) return compareString(s,t) ? s:"";
        if (s.length() < t.length()) return "";
        if (s.indexOf(t) >=0) return t;
        String result = "";
        if (t.length() >1) {
            int left = 0;
            while (left <= s.length()-t.length()) {
                List<Integer> foundList = findTargetStringCharIndexes(s,t,left);
                int min  = Collections.min(foundList);
                int max = Collections.max(foundList);
                if (foundList.size() == t.length()) {
                    String sub =  s.substring(min,max +1);
                    if (result.length() == 0 || sub.length() < result.length()) {
                        result = sub;

                    }
                    left  = max;

                } else if (foundList.size() == 0) {
                    left  = left + t.length();
                } else {
                    left = max;
                }

            }

        }
        return result;


    }

    static ArrayList<Integer> findTargetStringCharIndexes (String s, String t, int left) {
        ArrayList<Integer> foundList = new ArrayList<>();
        String sub = s.substring(left,left+t.length());
        for (int i= 0;i<t.length();i++) {
            if (sub.lastIndexOf(t.charAt(i)) != -1) {
                foundList.add(left+i);
            }
        }
        return foundList;
    }


    static String minWindow(String s, String t) {
        if (s.length() == t.length()) return compareString(s,t) ? s:"";
        if (s.length() < t.length()) return "";
        if (s.indexOf(t) >=0) return t;
        String result = "";
        if (t.length() > 1) {
            HashMap<Character, Integer> mapT = getCharacterMap(t);
            HashMap<Character, Integer> mapS = getCharacterMap(s);
            for (int i = 0; i < s.length() - t.length() + 1; i++) {
                if (i == 0 && compareMaps(mapS, mapT)) {
                    result = s;
                } else if (i > 0) {
                    mapS.put(s.charAt(i - 1), mapS.get(s.charAt(i - 1)) - 1);
                    if (compareMaps(mapS, mapT)) result = s.substring(i);
                }

            }
            String resultOther = "";
            HashMap<Character, Integer> mapS1 = getCharacterMap(s);
            for (int j = s.length() - 2; j >= t.length()-1 ; j--) {

                mapS1.put(s.charAt(j + 1), mapS1.get(s.charAt(j + 1)) - 1);
                if (compareMaps(mapS1, mapT)) resultOther = s.substring(0, j + 1);


            }
            //System.out.println("mapS1" + mapS1);
            //System.out.println("other" +resultOther);
            if (resultOther.length()>0 && resultOther.length() <= result.length()) result = resultOther;

            String resultOtherMiddle = "";
            HashMap<Character, Integer> mapS2 = getCharacterMap(s);
            for (int l =1,m=s.length()-2;m-l>=t.length()-1;l++,m--) {
                mapS2.put(s.charAt(l - 1), mapS2.get(s.charAt(l - 1)) - 1);
                mapS2.put(s.charAt(m + 1), mapS2.get(s.charAt(m + 1)) - 1);
                if (compareMaps(mapS2,mapT)) resultOtherMiddle = s.substring(l,m+1);

            }
            if(resultOtherMiddle.length() > 0 && resultOtherMiddle.length()<=result.length()) result= resultOtherMiddle;

        }
//        for (int i = 0; i < s.length() - t.length() + 1; i++) {
//            String s1 = s.substring(i, i + t.length());
//            if (compareString(s1, t)) {
//                return s1;
//            }
//        }
//        for (int j = 0; j < s.length() - t.length(); j++) {
//            String s2 = s.substring(j, j + t.length() + 1);
//            if (checkSubString(s2, t)) {
//                return s2;
//            }
//        }
        return result;
    }

    static HashMap<Character, Integer> getCharacterMap(String s) {
        HashMap<Character, Integer> mapS = new HashMap<>();
        for (int k = 0; k < s.length(); k++) {
            if (!mapS.containsKey(s.charAt(k))) {
                mapS.put(s.charAt(k), 1);
            } else {
                mapS.put(s.charAt(k), mapS.get(s.charAt(k)) + 1);
            }
        }
        return mapS;

    }

    static boolean compareMaps(HashMap<Character, Integer> mapS, HashMap<Character, Integer> mapT) {
        int count = 0;
        for (Map.Entry<Character, Integer> e : mapT.entrySet()) {
            if (mapS.containsKey(e.getKey())) {
                if (mapT.get(e.getKey()) <= mapS.get(e.getKey())) count++;
            }
        }
        if (count == mapT.size()) return true;
        return false;
    }

    static boolean compareString(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        return Arrays.equals(sChar, tChar);

    }

    static boolean checkSubString(String s, String t) {
        Map<Character, Integer> mapT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (!mapT.containsKey(t.charAt(i))) {
                mapT.put(t.charAt(i), 1);
            } else {
                mapT.put(t.charAt(i), mapT.get(t.charAt(i)) + 1);
            }
        }
        Map<Character, Integer> mapS = new HashMap<>();
        for (int k = 0; k < s.length(); k++) {
            if (!mapS.containsKey(s.charAt(k))) {
                mapS.put(s.charAt(k), 1);
            } else {
                mapS.put(s.charAt(k), mapS.get(s.charAt(k)) + 1);
            }
        }
        System.out.println("s:" + s + " mapS:" + mapS);
        System.out.println("t: " + t + " mapT:" + mapT);
        int count = 0;
        for (int j = 0; j < t.length(); j++) {
            Character ch = t.charAt(j);
            if (mapS.containsKey(ch)) {
                if (mapT.get(ch) <= mapS.get(ch)) {
                    count++;
                }
            }

        }
        if (count == t.length()) {
            return true;
        }
        return false;
    }


}
