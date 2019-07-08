package recursion;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.*;

public class AllSubStrings {

    //static Set<String> subStrings_r = new HashSet<>();
    //static List<String> subStrings_req = new ArrayList<>();

    public static void main(String[] args) {
        Instant start =  Instant.now();
//        String testString = "geeksforgeeks";
//        //String testString = "abcab";
//        //String testString = "aba";
//        //System.out.println(countOccurrences(testString,"ee"));
//        Set<String> subStrings_r = new HashSet<>();
//        getSubstrings_r(testString, subStrings_r);
//        System.out.println("RECURSION ->" + subStrings_r);
//        int count = 0;
//        for (String s : subStrings_r
//        ) {
//            int count_occ = countOccurrences(testString, s);
//            count = count + count_occ;
//        }
//
//
//        System.out.println(count);
        Scanner sc= new Scanner(System.in);
        int T = sc.nextInt();
        //int[] val = new int[T];
        for (int i = 0; i < T; i++) {
            int N= sc.nextInt();
            String str = sc.next();
            Set<String> subStrings_r = new HashSet<>();
            getSubstrings_r(str,subStrings_r);
            //System.out.println("RECURSION ->" + subStrings_r);
            int count = 0;
            for (String s : subStrings_r
            ) {
                int count_occ = countOccurrences(str, s);
                count = count + count_occ;
            }
            System.out.println(count);

        }
        Instant finish = Instant.now();
        System.out.println("time taken:" + Duration.between(start, finish).toMillis());

    }

    static int countOccurrences(String str, String sub) {
        int count = 0, fromIndex = 0;
        while ((fromIndex = str.indexOf(sub, fromIndex)) != -1) {
            count++;
            fromIndex++;
        }
        return count;

    }

    public static void getSubstrings_r(String testString, Set<String> subStrings_r) {
        _getSubstrings_r(testString, 0, testString.length(), subStrings_r);
    }

    public static void _getSubstrings_r(String testString, int start, int end, Set<String> subStrings_r) {
        if (start == end) { //base condition
            return;
        }
        String sub = testString.substring(start, end);
        if (sub.charAt(0) == sub.charAt(sub.length() - 1))
            subStrings_r.add(sub);
        //start getting substrings from left to right
        _getSubstrings_r(testString, start + 1, end, subStrings_r);
        //start getting substrings from right to left
        _getSubstrings_r(testString, start, end - 1, subStrings_r);
    }
}
