package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SearchTwoDMatrix {

    public static void main(String ar[]) {
        //int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        int[][] matrix = {{1}};
        //System.out.println(searchMatrix(matrix,5));
        System.out.println(searchMatrixRowWise(matrix, 1));


    }

    static boolean searchMatrixRowWise(int[][] matrix, int target) {
        int rows = matrix.length;
        if (rows > 0) {
            int cols = matrix[0].length;
            for (int i = 0; i < rows; i++) {
                int findIndex = binarySearch(matrix[i], target);
                if (findIndex !=-1) {
                    return  true;
                }

            }
        }
        return false;
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


//        public static boolean searchMatrix ( int[][] matrix, int target){
//            boolean found = false;
//            if (matrix.length > 0) {
//                int rows = matrix.length;
//                int cols = matrix[0].length;
//                int[] fullArr = new int[rows * cols];
//
//                List<Integer> list = new ArrayList<>();
//                for (int i = 0; i < matrix.length; i++) {
//                    List<Integer> small = new ArrayList<>();
//                    for (int j : matrix[i]) {
//                        small.add(j);
//                    }
//                    list.addAll(small);
//                }
//                Integer[] my1Darr = new Integer[list.size()];
//                my1Darr = list.toArray(my1Darr);
//                int index = binarySearch(my1Darr, target);
//                if (index != -1) {
//                    found = true;
//                }
//            }
//
//            return found;
//
//        }


//    static int binarySearch(Integer[] arr, int num) {
//        Integer l = 0;
//        Integer r = arr.length - 1;
//        Integer mid = 0;
//        while (r >= l) {
//            mid = (l + r) / 2;
//            if (arr[mid] == num) {
//                return mid;
//            } else if (arr[mid] < num) {
//                l = mid+1 ;
//            } else {
//                r = mid-1 ;
//            }
//        }
//        return -1;
//
//    }
}
