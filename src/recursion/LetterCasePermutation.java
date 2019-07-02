package recursion;

import java.util.*;

public class LetterCasePermutation {
    public static void main(String[] ar) {
        String S = "a1b2";
        if (S.charAt(0) == 97) {
            System.out.println("yes");
        }
        Map<Integer,Character> m = new HashMap<>();
        //m.con
        Set<String> set = new HashSet<>();
        set.add("as");
        set.add("aS");
        Object[] arr = set.toArray();
        System.out.println(Arrays.toString(arr));

    }

    static List<String> findLetterCasePermutation(String S) {
        return null;
    }
}
