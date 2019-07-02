package arrays;

import java.util.*;

public class FindingNumberBitonicArray {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scan.nextInt();
            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = scan.nextInt();
            }
            int X = scan.nextInt();
            int foundIndex = findNumberBitonicArray(arr, X, N);
            if (foundIndex != -1) {
                System.out.println(foundIndex);
            } else {
                System.out.println("" + foundIndex);
            }

        }
    }

    static int findNumberBitonicArray(int[] arr, int num, int N) {
        int max = 0, index = 0;
        for (int i = 0; i < N; i++) {
            if (max <= arr[i]) {
                index = i;
                max = arr[i];
            } else {
                break;
            }
        }
        if (index <= N-1) {
            int[] arr1 = Arrays.copyOfRange(arr, 0, index + 1);
            //System.out.println(Arrays.toString(arr1));
            int find = binarySearch(arr1, num);
            if (find == -1) {
                int[] arr2 = Arrays.copyOfRange(arr, index, N);
                int find1 = reverseBinarySearch(arr2, num);
                if (find1 != -1) {
                    find = index+find1;
                }
            }
            return find;
        } else  {
            return -1;
        }



    }
    static int reverseBinarySearch(int[] arr, int num) {
        int l = 0;
        int r = arr.length - 1;
        int mid = 0;
        while (r >= l) {
            mid = (l + r) / 2;
            if (arr[mid] == num) {
                return mid;
            } else if (arr[mid] < num) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    static int binarySearch(int[] arr, int num) {
        int l = 0;
        int r = arr.length - 1;
        int mid = 0;

        while (r >= l) {
            mid = (l + r) / 2;
            if (arr[mid] == num) {
                return mid;
            } else if (arr[mid] < num) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;

    }


}

