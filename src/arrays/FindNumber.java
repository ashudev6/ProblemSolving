package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindNumber {

    public static void main(String[] ar ) {
        List<Integer> list = new ArrayList<>();
//        for (int i = 1; i <=5 ; i++) {
//            list.add(i);
//        }
//        int index = Collections.binarySearch(list,1);
        System.out.println(findNumber(list,50));
        String strInput = "A man, a plan, a canal: Panama";
        String strWithoutNonAphaNums = strInput.replaceAll("[^A-Za-z0-9]","");
        strWithoutNonAphaNums  = strWithoutNonAphaNums.toLowerCase();
        System.out.println("orig:"+strWithoutNonAphaNums);
        StringBuilder str = new StringBuilder(strWithoutNonAphaNums);
        str.reverse();
        System.out.println("rev:"+str);
        //str  = str.toLowerCase();
        String revstrWithoutNonAphaNums = str.toString();
        revstrWithoutNonAphaNums.toLowerCase();
        if (strWithoutNonAphaNums.equals(revstrWithoutNonAphaNums)) {
            System.out.println(strInput.length());
            //return strInput.length();
        } else {
            System.out.println(-1);
            //return -1;
        }
//        System.out.println(str.replaceAll("[^A-Za-z0-9]", ""));
//        String input = "Geeks for Geeks";
//
//        StringBuilder input1 = new StringBuilder();
//
//        // append a string into StringBuilder input1
//        input1.append(input);
//
//        // reverse StringBuilder input1
//        input1 = input1.reverse();
//
//        // print reversed String
//        System.out.println(input1);

    }

    static String findNumber(List<Integer> arr, int k) {
        if (Collections.binarySearch(arr,k) >= 0) {
            return "YES";
            //System.out.println("YES");
        }
        return "NO";


    }
}
