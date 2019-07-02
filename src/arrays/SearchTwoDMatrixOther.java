package arrays;

import java.util.Arrays;

public class SearchTwoDMatrixOther {

    public static void main(String ar[]) {
        //int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        //int[][] matrix = {{1}};
        //System.out.println(searchMatrix(matrix,5));
        int [][] matrix = {{3,3,8,13,13,18},{4,5,11,13,18,20},{9,9,14,15,23,23},{13,18,22,22,25,27},{18,22,23,28,30,33},{21,25,28,30,35,35},{24,25,33,36,37,40}};
        //System.out.println(searchMatrix(matrix, 21));
        //int[][] matrix = {{}};
        //int [][] matrix1 = {{4,5},{4,6},{9,14},{10,15}};

        System.out.println(searchMatrix(matrix, 5));

    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows, cols;
        // Input check
        if (matrix == null || (rows = matrix.length) == 0 || (cols = matrix[0].length) == 0) {
            return false;
        }

        for (int row = 0, col = cols - 1; row >= 0 && row < rows && col >= 0 && col < cols;) {
            if (matrix[row][col] == target) {
                // Found target
                return true;
            }
            if (matrix[row][col] < target) {
                // Target is greater than current number, binary search row in [row + 1, rows - 1] in current column
                row = binarySearchInCol(matrix, target, rows, cols, col, row + 1, rows - 1);
            } else {
                // Target is smaller than current number, binary search col in [0, col - 1] in current row
                col = binarySearchInRow(matrix, target, rows, cols, row, 0, col - 1);
            }
        }
        return false;
    }

    private static  int binarySearchInRow(int[][] matrix, int target, int rows, int cols, int row, int low, int high) {
        if (low > high) {
            return cols;
        }
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (matrix[row][mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static int binarySearchInCol(int[][] matrix, int target, int rows, int cols, int col, int low, int high) {
        if (low > high) {
            return rows;
        }
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (matrix[mid][col] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static boolean searchMatrixTimeMN(int[][] grid, int target) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return false;
        }
        int rows = grid.length;
        int cols = grid[0].length;

        // Start at top right corner
        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0) {
            if (grid[row][col] == target) {
                return true;
            } else if (grid[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }




}
