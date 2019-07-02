package arrays;

import java.util.Arrays;

public class CountingElementsTwoArrays {
    public static void main(String[] ar) {
        int[] arr1 = {4, 8, 7, 5, 1};
        int[] arr2 = {4, 48, 3, 0, 1, 1, 5};
        int[] arr3 = {1, 2, 3, 4, 7, 9};
        int[] arr4 = {0, 1, 2, 1, 1, 4};
        countElements(arr1, arr2);
        int[] arr5 = {73, 92, 90, 28, 67, 79, 13, 51, 97, 25};
        int[] arr6 = {43, 65, 98, 8, 56, 5, 49, 12, 23, 29, 100, 44, 47, 69, 41, 23, 12, 11, 6, 2, 62, 31, 79, 6, 21, 37, 45, 27, 23, 66, 9, 17, 83, 59, 25, 38, 63, 25, 1, 37, 53, 100, 80, 51};
//        Arrays.sort(arr5);
//        System.out.println(Arrays.toString(arr5));
//        System.out.println(searchElementIndexLessThanEqualTo(arr5, 9));

    }
    static void countElements(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        int j = 0;
        int[] count = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            int findIndex = searchElementIndexLessThanEqualTo(arr2, arr1[i]);
            if (findIndex != -1) {
                count[i] = findIndex + 1;
            } else {
                count[i] = 0;
            }

        }

        for (int k = 0; k < count.length; k++) {
            System.out.print(count[k]);
            System.out.print(" ");
        }

    }
    static int searchElementIndexLessThanEqualTo(int[] arr, int num) {
        if (arr.length > 1) {
            int l = 0;
            int r = arr.length - 1;
            int m = 0;
            while (r > l) {
                m = (r + l) / 2;
                if (m == 0 && arr[m] > num) {
                    return -1;
                }
                if ((arr[m] == num && arr[m + 1] > num) || (arr[m] < num && arr[m + 1] > num)) {
                    return m;
                } else if ((arr[m] < num && arr[m + 1] >= num) || (arr[m] == num && arr[m + 1] == num) || (arr[m] < num && arr[m + 1] < num)) {
                    l = m + 1;
                } else if (arr[m] > num && arr[m - 1] <= num) {
                    return m - 1;
                } else if (arr[m] > num && arr[m - 1] > num) {
                    r = m - 1;
                }
            }
            if (arr[r] > num) {
                return -1;
            }
            return r;


        } else if (arr.length == 1) {
            if (arr[0] <= num) {
                return 0;
            }
        }
        return -1;
    }


}
