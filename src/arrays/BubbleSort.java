package arrays;

import javax.swing.plaf.synth.SynthUI;
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] ar) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        bubbleSort(arr, N);
    }

    static void bubbleSort(int[] arr, int N) {
        for (int j = N - 1; j > 0; j--) {
            for (int i = j - 1; i >= 0; i--) {
                if (arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int k : arr
        ) {
            System.out.println(k);

        }
    }
}
