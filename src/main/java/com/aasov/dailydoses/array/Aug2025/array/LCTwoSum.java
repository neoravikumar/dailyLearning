package com.aasov.dailydoses.array.Aug2025.array;

import java.util.*;

public class LCTwoSum {
    public static void main(String[] args) {
        int[] myInput = {3,3};
        int[] result = LCTwoSum.twoSum(myInput,6);
        System.out.println("Result >>"+Arrays.toString(result));
    }

    public static int[] twoSum(int[] nums, int target) {

        List input = new ArrayList<Integer>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            input.add(nums[i]);
        }
        for (int i = 0; i < nums.length-1; i++) {
            Integer abc = (Integer) input.get(i);
            Integer dev = (Integer) input.get(i+1);
            if (abc+dev==target) {
                result[0] = i;
                result[1] = input.indexOf(target - nums[i]);
                return result;
            }
        }
        return result;
    }
}
