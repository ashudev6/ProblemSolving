package recursion;

public class BinarySearch {

    public static void main(String[] ar) {
        int[] arr = {1, 4, 8, 10, 13, 50};
        int key = -3;
        System.out.println("index of key " + key + " is: " + binarySearch(arr, key));
    }

    static int binarySearch(int[] arr, int key) {
        return helper(arr, key, 0, arr.length - 1);
    }

    static int helper(int[] arr, int key, int left, int right) {
        if (left > right) return -1;
        int mid = (left + right) / 2;
        if (arr[mid] == key) return mid;
        else if (arr[mid] < key) {
            return helper(arr, key, mid + 1, right);
        } else {
            return helper(arr, key, 0, mid - 1);
        }

    }


}
