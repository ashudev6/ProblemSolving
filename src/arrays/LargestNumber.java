package arrays;

import java.util.*;

public class LargestNumber {

    public static void main(String[] args) {
        //int [] nums = { 3,30,34,5,9};
        int[] nums = {121, 12, 1209};
        //System.out.println(largestNumber(nums));
//         List L = new LinkedList<>();
//         L.add("ashu");
//         L.add("ashu");
//        System.out.println(L.toString());
//        System.out.println(L.lastIndexOf("ashu"));
//        HashSet hashSet = new HashSet();
//        TreeSet treeSet = new TreeSet<>();
//        treeSet.add(425);
//        treeSet.add(415);
//        System.out.println(treeSet.toString());
//        Map<Integer,Integer> map = new HashMap<>();
//        PriorityQueue priorityQueue = new PriorityQueue();
        int[] arr = {1, 2, 3, 4};
        System.out.println(binarySearch(arr, 40));

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
                 l = mid+1 ;
            } else {
                 r = mid-1 ;
            }
        }
        return -1;

    }

    public static String largestNumber(int[] nums) {
        Arrays.sort(nums);
        int last = nums.length - 1;
        int onesp = -1;
        String largestNumber = "";
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] / 10 < 1) {
                onesp = i;
            } else {
                break;
            }
        }
        if (onesp > -1) {
            int lastNumDigit = calculate10Power(nums[last]);
            if (lastNumDigit < 1) {
                for (int j = last; j >= 0; j--) {
                    largestNumber = largestNumber + Integer.toString(nums[j]);
                }
            } else {
                for (int m = onesp, n = last; m >= 0 || n > onesp; ) {
                    if (m >= 0 && n > onesp) {
                        int endDigit = calculate10Power(nums[n]);
                        if (endDigit > 0) {
                            int BiggestOneDigit = multiply10Power(nums[m], endDigit);
                            if (BiggestOneDigit >= nums[n]) {
                                largestNumber = largestNumber + Integer.toString(nums[m]);
                                m--;
                            } else {
                                largestNumber = largestNumber + Integer.toString(nums[n]);
                                n--;
                            }
                        }
                    } else if (m < 0) {
                        largestNumber = largestNumber + Integer.toString(nums[n]);
                        n--;
                    } else if (n == onesp) {
                        largestNumber = largestNumber + Integer.toString(nums[m]);
                        m--;
                    }
                }
            }
        } else {
//            for (int a = nums.length-1; a >= 0; a--) {
//                largestNumber = largestNumber + Integer.toString(nums[a]);
//            }
            for (int b = nums.length - 1; b >= 0; ) {
                String lastNumber = "";
                if (b == nums.length - 1) {
                    lastNumber = Integer.toString(nums[b]);
                } else {
                    lastNumber = largestNumber;
                }
                if (b > 1) {
                    String x = lastNumber + Integer.toString(nums[b - 1]);
                    String y = lastNumber + Integer.toString(nums[b - 2]);
                    if (Integer.parseInt(x) >= Integer.parseInt(y)) {
                        largestNumber = x;
                    } else {
                        largestNumber = y;
                    }
                    b = b - 2;
                } else {
                    break;
                }


            }

        }

        return largestNumber;
    }


    static int calculate10Power(int num) {
        int count = 0;
        while (num / 10 > 0) {
            num = num / 10;
            count++;
        }
        return count;
    }

    static int multiply10Power(int num, int power) {
        while (power > 0) {
            num = num * 10;
            power--;
        }
        return num;
    }


}
