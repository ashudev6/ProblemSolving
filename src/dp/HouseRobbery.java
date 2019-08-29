package dp;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class HouseRobbery {

    public static void main(String [] ar) {
        int[] nums = {2,3,2};
        System.out.println(rob(nums));

    }

    public static int rob(int[] nums) {
        int sum = 0;
        int maxIndex = findMaxHelper(nums);
        int maxi = maxIndex;
        //System.out.println("maxi : " + maxIndex);
        Set<Integer> vals = new HashSet<>();
        Set<Integer> finalvals = new HashSet<>();
        sum = nums[maxIndex];
        int count = 1;
        vals  = setHelper(vals,maxIndex,nums);
        finalvals.add(maxIndex);
        //System.out.println(vals);
        for (int i = count;i<(int)Math.ceil((double) nums.length/2);i++) {
            maxIndex = findMaxIndex(nums,maxIndex,vals);
            if (maxIndex!=-1) {
                //System.out.println("maxi : " + maxIndex);
                vals = setHelper(vals,maxIndex,nums);
                finalvals.add(maxIndex);
                //System.out.println(vals);
                sum = sum + nums[maxIndex];
            }
        }
        System.out.println("finalvals: " + finalvals);
        System.out.println("sum: " + sum);
        //finalvals.remove(maxi);
        Set<Integer> vals1 = new HashSet<>();
        vals1.add(maxi);
        Set<Integer> finalvals1 = new HashSet<>();
        int sum1 = 0;
        if (maxi!= 0) {
            maxIndex = 0;
        } else {
            maxIndex = 1;
        }
        System.out.println("maxi1 : " + maxIndex);
        sum1 = nums[maxIndex];
        int count1 = 1;
        vals1  = setHelper(vals1,maxIndex,nums);
        finalvals1.add(maxIndex);
        System.out.println(vals1);
        for (int i = count1;i<(int)Math.ceil((double) nums.length/2);i++) {
            maxIndex = findMaxIndex(nums,maxIndex,vals1);
            if (maxIndex!=-1) {
                System.out.println("maxi1 : " + maxIndex);
                vals1 = setHelper(vals1,maxIndex,nums);
                finalvals1.add(maxIndex);
                System.out.println("vals1: "+ vals1);
                sum1 = sum1 + nums[maxIndex];
            }
        }
        System.out.println("finalvals1: " +finalvals1);
        System.out.println("sum1: " + sum1);
        return sum >= sum1 ? sum: sum1;
        //return sum;

    }

    static Set<Integer> setHelper (Set<Integer> vals, int maxIndex,int[] nums) {
        vals.add(maxIndex);
        if (maxIndex -1 >=0) vals.add(maxIndex-1);
        if (maxIndex+1 < nums.length)vals.add(maxIndex+1);
        return vals;

    }

    static int findMaxHelper (int[] nums) {
        int maxVal = 0;
        int maxIndex = -1;
        for (int i = 0;i<nums.length;i++) {
            if (nums[i] > maxVal) {
                maxIndex = i;
                maxVal = nums[i];
            }
        }
        return maxIndex;
    }

    static int findMaxIndex(int[] nums,int index,Set<Integer>vals) {
        int maxVal = 0;
        int maxIndex = -1;
        for (int i = 0;i<nums.length;i++) {
            if (!vals.contains(i)) {
                if (nums[i] > maxVal) {
                    maxIndex = i;
                    maxVal = nums[i];
                }
            }
        }
        return maxIndex;
    }
}
