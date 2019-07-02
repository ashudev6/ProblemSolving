package arrays;

import java.util.Scanner;

public class SelectionSort {

    public static void main(String[] ar) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        selectionSort(arr, N);
    }

    static  void  selectionSort(int[] arr,int N) {
        int j  = 0;
        while (j<N-1) {
            int min_index = j;
            for (int i = j+1; i < N; i++) {
                 if (arr[i]<arr[min_index]) {
                     min_index = i;

                 }
            }
            if (arr[min_index] < arr[j]) {
                int temp = arr[j];
                arr[j] = arr[min_index];
                arr[min_index] = temp;
            }
            j++;

        }

        for (int k : arr
        ) {
            System.out.println(k);

        }
    }
}
