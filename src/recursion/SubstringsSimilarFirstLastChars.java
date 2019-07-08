package recursion;

import java.util.*;

public class SubstringsSimilarFirstLastChars {

    //static Set<String> set = new HashSet<>();
    //static List<String> list = new ArrayList<>();
    public static void main (String[] args) {
        //String str = "aba";
        String str = "geeksforgeeks";
        List<String> list = new ArrayList<>();
        countSubstringsSimilarFirstLastChars(str,list);
        System.out.println(list );
        //System.out.println(str.substring(1,13));
//        countSubstringsSimilarFirstLastChars(str,0,str.length());
//        Scanner sc= new Scanner(System.in);
//        int T = sc.nextInt();
//        int[] val = new int[T];
//        for (int i = 0; i < T; i++) {
//             int N= sc.nextInt();
//             String str = sc.next();
//             str.su
//             val[i] =  getAllSubstrings(str);
//        }
//        for (int i = 0; i < T; i++) {
//             System.out.println(val[i]);
//        }
        //getAllSubstrings(str);
        //System.out.println(list.toString()+ " size :" +list.size());
//        System.out.println(set.size()+str.length());



    }

    static void countSubstringsSimilarFirstLastChars(String str,List<String> list) {
        if(str.length() ==1) return;
        if (str.length()>1) {
            //List<String> list = new ArrayList<>();
            String sub  = str.substring(1);
            generateSubStrings(sub,list);
            //System.out.println(list.toString());
            return;
            //return list.size();
        }
        //return 0;

    }

    static void generateSubStrings(String str,List<String> list) {
        if (str.length() == 1) {
            list.add(str);
            return;
        }
        if (str.length()>1) {
            list.add(str);
            generateSubStrings(str.substring(0,str.length()-1),list);
        }
    }


    static int getAllSubstrings(String str) {
        List<String> list = new ArrayList<>();
        if (str.length()> 0) {
            for (int i = 0; i < str.length() - 1; i++) {
                for (int j = i; j < str.length(); j++) {
                    if (i == j) {
                        list.add(String.valueOf(str.charAt(i)));
                    } else {
                        String sub = str.substring(i, j + 1);
                        if (sub.charAt(0) == sub.charAt(sub.length() - 1)) list.add(sub);

                    }
                }

            }
            list.add(String.valueOf(str.charAt(str.length()-1)));
        }
        return list.size();
    }





}
