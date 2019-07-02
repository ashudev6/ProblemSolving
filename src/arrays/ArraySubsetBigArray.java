package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArraySubsetBigArray {

    public static void main(String[] ar) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0;t<T;t++) {
            int N1 = sc.nextInt();
            int N2 = sc.nextInt();
            int[] arr1 = new int[N1];
            int[] arr2 = new int[N2];
            for (int i = 0; i < N1; i++) {
                arr1[i] = sc.nextInt();
            }
            for (int j = 0; j < N2; j++) {
                arr2[j] = sc.nextInt();
            }
            System.out.println(findSubset(arr1, arr2));
        }
    }

    static String findSubset(int[] arr1, int[] arr2) {
        int count = 0;
        if (arr1.length< arr2.length) {
            return "No";
        } else {
            for (int i = 0; i < arr2.length; i++) {
                Arrays.sort(arr1);
                int index = new SearchTwoDMatrix().binarySearch(arr1,arr2[i]);
                System.out.println("index of: " +arr2[i]+ "is :" + index);
                if (index!=-1) {
                    count++;
                }
            }
            if (count == arr2.length) {
                return "Yes";
            } else {
                return  "No";
            }
        }

    }
}
