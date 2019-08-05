package queues;

import java.util.*;

public class SlidingWindow {

    public static void main(String[] arg) {
        int[] nums = {1, -9, 8, -6, 6, 4, 0, 5};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 4)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        Queue<Integer> q = new LinkedList();
        List<Integer> output = new ArrayList<>();
        int max_index = 0;
        if (nums.length > 0) {
            if (k == 1) {
                return nums;
            }
            for (int i = 0; i < k; i++) {
                if (nums[i] > nums[max_index]) max_index = i;
            }
            q.offer(max_index);
            output.add(nums[max_index]);
            //for (int j =k;j <nums.length;j++) {
            int j = k;
            while (!q.isEmpty() && j < nums.length) {
                if (nums[q.peek()] <= nums[j]) {
                    q.poll();
                    q.offer(j);
                    output.add(nums[j]);
                    j++;
                } else {
                    if (j - q.peek() >= k) {
                        int l_max_index = findMaxIndex(nums, q.peek() + 1, j);
                        if (l_max_index > q.peek()) {
                            q.poll();
                            q.offer(l_max_index);
                        }


                    } else {
                        output.add(nums[q.peek()]);
                        j++;
                    }

                }
            }
        }
        int[] maxNums = output.stream().mapToInt(i -> i).toArray();
        return maxNums;


    }

    static int findMaxIndex(int[] arr, int beg, int end) {
        int max_index = end;
        for (int i = end; i >= beg; i--) {
            if (arr[i] > arr[max_index]) {
                max_index = i;
            }
        }
        return max_index;
    }
}
