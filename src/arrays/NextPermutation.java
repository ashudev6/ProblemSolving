package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class NextPermutation {



    public static void main(String[] ar) throws IOException {
//        Scanner scan = new Scanner(System.in);
//        int T = scan.nextInt();
//       String [] strings = new String[T];
//        for (int i = 0; i < T; i++) {
//            int N = scan.nextInt();
//            int[] arr = new int[N];
//            for (int j = 0; j < N; j++) {
//                arr[j] = scan.nextInt();
//            }
//            strings[i] = findNextPermutation(arr, N);
//        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        String [] strings = new String[t];
        for (int i = 0; i < t; i++) {
            String[] strs1 = new FindFloor().findNumbers(br);
            int N = Integer.parseInt(strs1[0]);
            //int num = Integer.parseInt(strs1[1]);
            String[] strs2 = new FindFloor().findNumbers(br);
            int[] arr = new int[N];
            for (int j =0;j<strs2.length;j++) {
                arr[j] = Integer.parseInt(strs2[j]);
            }
            strings[i] = findNextPermutation(arr,N);
        }

        for (int i = 0; i < t; i++) {
             System.out.println(strings[i]);
        }
//          String s= "6835170257959636564682";
//          BigInteger numBig = new BigInteger(s);
//          System.out.println(numBig);



    }

    static String findNextPermutation(int[] arr,int N) {
       if (N ==1) return  Integer.toString(arr[0]);
       StringBuilder num = new StringBuilder();
        for (int i = 0; i < N; i++) {
             num.append(arr[i]);
        }
        BigInteger numBig = new BigInteger(num.toString());
        //System.out.println("num:" + numBig);
        Arrays.sort(arr);
        int[] arr1 = new int[N];
        for (int k = 0; k < N; k++) {
             arr1[k] = arr[k];
        }
        Set<BigInteger> set = new TreeSet<BigInteger>();
        printAllRecursive(N,arr,set);
        //System.out.println("set:"+set.toString());
        Integer i = 0;
        //BigInteger found = new BigInteger(i);
        String found  = "";
        for (BigInteger b:
             set) {
            int compareValue = b.compareTo(numBig);
            if (compareValue == 1) {
                found = b.toString();
                break;
            }
        }
        //System.out.println("found :"+found);
        Map<Integer,String> finalValue = new TreeMap<>();
        for (int j = 0; j < N; j++) {
             if (found.contains(Integer.toString(arr1[j]))) {
                 //System.out.print("index: " +found.lastIndexOf(Integer.toString(arr1[j])) +" ");
                 int index = found.lastIndexOf(Integer.toString(arr1[j]));
                 //System.out.print(arr1[j]);
                 finalValue.put((Integer)index,Integer.toString(arr1[j]));
             }
        }
        //System.out.println(finalValue.toString());
        StringBuffer finalValueString  = new StringBuffer();
        for (Map.Entry<Integer,String> entry : finalValue.entrySet()
             ) {
             //System.out.print(entry.getValue() + " ");
             finalValueString.append(entry.getValue() + " ");
        }
        //System.out.println("done");
        return finalValueString.toString();

       //return arr;
    }

    static String findNextPermutationInt(int[] arr,int N) {
        if (N ==1) return  Integer.toString(arr[0]);
        StringBuilder num = new StringBuilder();
        for (int i = 0; i < N; i++) {
            num.append(arr[i]);
        }
        Integer numBig = Integer.parseInt(num.toString());
        //BigInteger numBig = new BigInteger(num.toString());
        //System.out.println("num:" + numBig);
        Arrays.sort(arr);
        int[] arr1 = new int[N];
        for (int k = 0; k < N; k++) {
            arr1[k] = arr[k];
        }
        Set<Integer> set = new TreeSet<Integer>();
        printAllRecursiveInt(N,arr,set);
        //System.out.println("set:"+set.toString());
        Integer i = 0;
        //BigInteger found = new BigInteger(i);
        String found  = "";
        for (Integer b:
                set) {
            if (b>numBig) {
                found = b.toString();
                break;
            }
        }
        //System.out.println("found :"+found);
        Map<Integer,String> finalValue = new TreeMap<>();
        for (int j = 0; j < N; j++) {
            if (found.contains(Integer.toString(arr1[j]))) {
                //System.out.print("index: " +found.lastIndexOf(Integer.toString(arr1[j])) +" ");
                int index = found.lastIndexOf(Integer.toString(arr1[j]));
                //System.out.print(arr1[j]);
                finalValue.put((Integer)index,Integer.toString(arr1[j]));
            }
        }
        //System.out.println(finalValue.toString());
        StringBuffer finalValueString  = new StringBuffer();
        for (Map.Entry<Integer,String> entry : finalValue.entrySet()
        ) {
            //System.out.print(entry.getValue() + " ");
            finalValueString.append(entry.getValue() + " ");
        }
        //System.out.println("done");
        return finalValueString.toString();

        //return arr;
    }

    public static void printAllRecursive(
            int n, int[] elements,Set<BigInteger>set) {

        if(n == 1) {
            printArray(elements,set);
        } else {
            for(int i = 0; i < n-1; i++) {
                printAllRecursive(n - 1, elements,set);
                if(n % 2 == 0) {
                    swap(elements, i, n-1);
                } else {
                    swap(elements, 0, n-1);
                }
            }
            printAllRecursive(n - 1, elements,set);
        }
        //return  null;
    }

    public static void printAllRecursiveInt(
            int n, int[] elements,Set<Integer>set) {

        if(n == 1) {
            printArrayInt(elements,set);
        } else {
            for(int i = 0; i < n-1; i++) {
                printAllRecursiveInt(n - 1, elements,set);
                if(n % 2 == 0) {
                    swap(elements, i, n-1);
                } else {
                    swap(elements, 0, n-1);
                }
            }
            printAllRecursiveInt(n - 1, elements,set);
        }
        //return  null;
    }

    static  private void swap(int[] input, int a, int b) {
        int tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }

    static  private void printArray(int[] input,Set<BigInteger>set) {
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < input.length; i++) {
            s.append(input[i]);
        }
        set.add(new BigInteger(s.toString()));

    }

    static  private void printArrayInt(int[] input,Set<Integer>set) {
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < input.length; i++) {
            s.append(input[i]);
        }
        set.add(Integer.valueOf(s.toString()));

    }
}
