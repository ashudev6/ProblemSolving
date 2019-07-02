package arrays;

public class CountOneInSortedBinaryArray {
    public  static void main(String[] ar) {
        int[] arr  = {1, 1, 1, 1, 1, 1, 1};
        int [] arr1 =  {0, 0, 0, 0, 0, 0, 0};
        int [] arr2 = {};
        System.out.println(countOnes(arr2));
    }
    static int countOnes(int[] arr) {
        int count = 0;
        int target = 1;
        int index_target = reverseBinarySearch(arr,target);
        if (index_target!= -1) {
            count++;
            for (int i = index_target + 1; i < arr.length; i++) {
                if (arr[i] == target) {
                    count++;
                } else {
                    break;
                }
            }
            for (int j = index_target-1; j >=0 ; j--) {
                if (arr[j] == target) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    static  int reverseBinarySearch(int[] arr,int num) {
        int l = 0;
        int r = arr.length - 1;
        int mid = 0;

        while (r >= l) {
            mid = (l + r) / 2;
            if (arr[mid] == num) {
                return mid;
            } else if (arr[mid] < num) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return -1;
    }
}
