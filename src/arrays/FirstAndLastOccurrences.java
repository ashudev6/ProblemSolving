package arrays;


import java.util.Arrays;
import java.util.Scanner;

public class FirstAndLastOccurrences {

    public static void main(String[] ar) {
        //int[] arr = {1, 3, 5, 5, 5, 5, 67, 123, 125};
        //int[] arr = {3};
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scan.nextInt();
            int target = scan.nextInt();
            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = scan.nextInt();
            }
            int[] output = findFirstAndLastOccurrences(arr, target);
            if (output[0] == -1) {
                System.out.println(output[0]);
            }else {
                for (int k: output) {
                    System.out.print(k);
                    System.out.print(" ");
                }
            }
              //System.out.println(Arrays.toString(findFirstAndLastOccurrences(arr, target)));
        }


    }

    static int[] findFirstAndLastOccurrences(int[] arr, int target) {
        int[] values = new int[2];
        int left_index = -1;
        int right_index = -1;
        int index_target = new SearchTwoDMatrix().binarySearch(arr, target);
        if (index_target != -1) {
            left_index = index_target;
            right_index = index_target;
            for (int i = index_target + 1; i < arr.length; i++) {
                if (arr[i] == target) {
                    right_index = i;
                } else {
                     break;
                }
            }
            for (int j = index_target-1; j >=0 ; j--) {
                 if (arr[j] == target) {
                     left_index = j;
                 } else {
                     break;
                 }
            }
        }
        values[0] = left_index;
        values[1] = right_index;
        return values;
    }
}
