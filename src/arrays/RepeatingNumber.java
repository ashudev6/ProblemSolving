package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RepeatingNumber {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scan.nextInt();
            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = scan.nextInt();
            }
            //findRepeating(arr, N);
            System.out.println(findRepeatingBinarySearch(arr, N));

        }
    }

    static int findRepeatingBinarySearch(int[] arr, int N) {
        int low = 0, mid = 0;
        int high = arr.length - 1;

        while (low < high) {
            mid = low + (high - low) / 2;

            if (arr[mid] == arr[mid + 1] || arr[mid] == arr[mid - 1]) {
                return arr[mid];
            } else if (arr[mid] > mid) {
                low = mid + 1;
            } else {

                high = mid - 1;
            }
        }
        return -1;
    }

    static void findRepeating(int[] arr, int N) {
        Map<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < N; i++) {
            if (!hm.containsKey(arr[i])) {
                hm.put(arr[i], 1);
            } else {
                //int value = hm.get(arr[i]);
                //hm.put(arr[i], value + 1);
                System.out.println(arr[i]);
                break;
            }
        }
    }


}
