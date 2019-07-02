package arrays;

import java.util.Scanner;
import java.lang.*;

public class ClosestNumberSortedArray {

    public static void main(String[] ar) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scan.nextInt();
            int K = scan.nextInt();
            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = scan.nextInt();
            }
            System.out.println(findClosestNumberSortedArray(arr, N, K));


        }
    }

    static int findClosestNumberSortedArray(int[] arr, int N, int K) {
        int insertPosition = new SearchInsert().searchInsert(arr, K);
        if (insertPosition == 0) {
            return arr[insertPosition];
        }
        if (arr.length == 1) {
            return arr[insertPosition];
        } else if (arr.length > 1 && insertPosition < arr.length - 1) {
            if (Math.abs(K - arr[insertPosition]) == Math.abs(arr[insertPosition + 1] - K)) {
                return arr[insertPosition + 1];
            } else if (Math.abs(arr[insertPosition]-K) > Math.abs(K- arr[insertPosition-1])){
                return arr[insertPosition-1];
            } else if (Math.abs(arr[insertPosition]-K) <= Math.abs(K- arr[insertPosition-1])) {
                return arr[insertPosition];
            }


        }
        if (insertPosition == N) {
            insertPosition--;
        }
        return arr[insertPosition];
    }
}
