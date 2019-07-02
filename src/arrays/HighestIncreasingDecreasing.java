package arrays;

public class HighestIncreasingDecreasing {
    public static void main(String[] args) {
        //int[] arr = {0, 1, 1, 2, 2, 2, 2, 2, 3, 4, 4, 5, 3, 3, 2, 2, 1, 1};
        int[] arr1 = {1, 3, 50, 10, 9, 7, 6};
        int[] arr2 = {10, 20, 30, 40, 50};
        int[] arr3 = {120, 100, 80, 20, 0};
        int[] arr4 = {1,5,4,3,2,1};
        //System.out.println(highestInIncreasingDecreasing(arr));
        System.out.println(highestInIncreasingDecreasing(arr1));
        System.out.println(highestInIncreasingDecreasing(arr2));
        System.out.println(highestInIncreasingDecreasing(arr4));
    }

    static int highestInIncreasingDecreasing(int[] arr) {
        if (arr.length == 0) {
            return -1;
        } else if (arr.length == 1 || arr.length == 2) {
            return arr[0];
        } else {
            int left = 0;
            int right = arr.length - 1;
            int mid = 0;
            while (right >= left) {
                mid = (left + right) / 2;
                if (mid == 0) {
                    if (arr[mid] >= arr[mid + 1]) {
                        return arr[mid];
                    } else {
                        return arr[mid + 1];
                    }
                }
                if (left == right) {
                    return arr[left];
                }
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                    return arr[mid];
                } else if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return -1;
        }
    }
}
