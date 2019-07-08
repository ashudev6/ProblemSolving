package recursion;

import java.util.*;
import java.util.stream.Stream;

public class LetterCasePermutation {

    static List list = new LinkedList();


    public static void main(String[] ar) {
        String S = "a1b2";
        list.clear();
        list.add(S);
        letterCasePermutationRecursion(S, 0);
        Stream.of(list).forEach(value -> System.out.println(value));

        S = "a1B2c1";
        list.clear();
        list.add(S);
        letterCasePermutationRecursion(S, 0);
        Stream.of(list).forEach(value -> System.out.println(value));

        S = "a";
        list.clear();
        list.add(S);
        letterCasePermutationRecursion(S, 0);
        Stream.of(list).forEach(value -> System.out.println(value));

        S = "O9";
        list.clear();
        list.add(S);
        letterCasePermutationRecursion(S, 0);
        Stream.of(list).forEach(value -> System.out.println(value));

        S = "TB";
        list.clear();
        list.add(S);
        letterCasePermutationRecursion(S, 0);
        Stream.of(list).forEach(value -> System.out.println(value));

        S = "Tb";
        list.clear();
        list.add(S);
        letterCasePermutationRecursion(S, 0);
        Stream.of(list).forEach(value -> System.out.println(value));


    }

    static void letterCasePermutationRecursion(String s, int index) {

        if (index > s.length() - 1) {
            return;
        }
        letterCasePermutationRecursion(s, index + 1);

        if (s.charAt(index) >= 'a' && s.charAt(index) <= 'z') {
            String val = "";
            if (index == 0) val = Character.toUpperCase(s.charAt(index)) + s.substring(index + 1);
            else {
                val = s.substring(0, index) + Character.toUpperCase(s.charAt(index)) + s.substring(index + 1);
            }
            list.add(val);
            letterCasePermutationRecursion(val, index + 1);
        }

        if (s.charAt(index) >= 'A' && s.charAt(index) <= 'Z') {
            String val = "";
            if (index ==  0) val = Character.toLowerCase(s.charAt(index)) + s.substring(index + 1);
            else {
                val = s.substring(0, index) + Character.toLowerCase(s.charAt(index)) + s.substring(index + 1);
            }
            list.add(val);
            letterCasePermutationRecursion(val, index + 1);
        }
    }
}
