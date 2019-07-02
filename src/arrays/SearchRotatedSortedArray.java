package arrays;

import java.util.Arrays;

public class SearchRotatedSortedArray {

    public static void main(String[] ar) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        int[] arr1 = {10, 20, 30, 40, 50, 7, 8, 9};
        int[] arr2 = {3, 1};
        int[] arr3 = {5, 1, 2, 3, 4};
        System.out.println(searchNumber(arr3, 1));
    }

    static int searchNumber(int[] arr, int target) {
        int index_found = -1;
        if (arr.length > 0) {
            int index_smallest = 0;
            if (arr.length == 2) {
                index_smallest = 1;
            } else {
                index_smallest = findShortestNumIndex(arr);
            }

            //int [] a1 = Arrays.copyOfRange(arr,0,index_smallest);
            //index_found = new SearchTwoDMatrix().binarySearch(a1,target);
            index_found = genericBinarySearch(arr, 0, index_smallest - 1, target);
            if (index_found != -1) {
                return index_found;
            } else {
                //int[] b1 = Arrays.copyOfRange(arr,index_smallest,arr.length);
                //index_found =  new SearchTwoDMatrix().binarySearch(b1,target);
                index_found = genericBinarySearch(arr, index_smallest, arr.length - 1, target);
                if (index_found != -1) {
                    //index_found = index_smallest+index_found;
                    return index_found;
                }
            }
        }
        return index_found;

    }

    static int genericBinarySearch(int[] arr, int l, int r, int num) {
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

    static int findShortestNumIndex(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        int m = 0;
        while (r >= l) {
            m = (r + l) / 2;
            if (m == 0) {
                return 1;
            }
            if (arr[l] == arr[r]) {
                return l;
            }
            if (arr[m] < arr[m - 1] && arr[m] < arr[m + 1]) {
                return m;
            } else if (arr[m] > arr[m - 1] && arr[m] > arr[m + 1]) {
                return m + 1;
            } else if (arr[m] > arr[m - 1] && arr[m] < arr[m + 1]) {
                if (findDirection(arr, m)) {
                    r = m - 1;

                } else {

                    l = m + 1;
                }
            }

        }
        return -1;

    }

    static boolean findDirection(int[] arr, int index) {
        boolean left = false;
        if (arr[0] > arr[index]) {
            left = true;
        } else {
            return left;
        }

        return left;
    }
}
