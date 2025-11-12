package com.aasov.dailydoses.array;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.*;

public class TwoSum {

    public static void main(String[] args) {
        int[] input = {3, 3};
        int[] result = twoSum(input, 6);
        System.out.println(Arrays.toString(result));
    }


    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no element found");
    }


}
