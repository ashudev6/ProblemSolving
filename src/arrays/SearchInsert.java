package arrays;

public class SearchInsert {
    public static void main(String[] ar) {
        int[] nums = {1, 3, 7};
        System.out.println(searchInsert(nums, 1));
    }

    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int m = 0;
        while (r >= l) {
            m = (l + r) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;


    }
}
