package com.aasov.dailydoses.array;

import java.math.BigInteger;
import java.util.*;

public class LeetCode {

    public static int thirdMax(int[] nums) {
        Integer max = null;
        Integer second_max = null;
        Integer third_max = null;

        for (Integer num : nums) {

            if (num.equals(max) || num.equals(second_max) || num.equals(third_max)) {
                continue;
            }
            if (max == null || num > max) {
                third_max = second_max;
                second_max = max;
                max = num;
            } else if (second_max == null || num > second_max) {
                third_max = second_max;
                second_max = num;
            } else if (third_max == null || num > third_max) {
                third_max = num;
            }

        }
        if (third_max == null) {
            return max;
        }
        return third_max;

    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {

        Set<Integer> resultList = new HashSet<>();
        int n = nums.length;
        for (int i = 1; i <= n; i++) {
            resultList.add(i);
        }
        for (Integer num : nums) {
            if (resultList.contains(num)) {
                resultList.remove(num);
            }

        }
        return resultList.stream().toList();
    }


    public static int[] sortedSquares(int[] nums) {
        //Square the Array
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] * nums[i];
        }

        // sort the array
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (nums[i] > nums[j]) {
                    LeetCode.swap(nums, i, j);
                }
            }
        }
        return nums;
    }

    static void swap(int nums[], int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;

    }

    public static int dominantIndex(int[] nums) {
        int result = -1;
        int max = Integer.MIN_VALUE;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            max = Math.max(nums[i], max);
        }

        for (int k = 0; k < n; k++) {
            if (max != nums[k]) {
                if (nums[k] * 2 > max) {
                    return -1;
                }

            } else if (max == nums[k]) {
                result = k;
            }
        }
        return result;
    }

    // Try to solve this using prefix sum
    public static int pivotIndex(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int k = i + 1; k < n; k++) {
                rightSum += nums[k];
            }
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
            rightSum = 0;
        }
        return -1;
    }

    public static int[] plusOne(int[] digits) {
        String data = "";
        for (int k : digits) {
            data += k;
        }
        BigInteger bigInteger = new BigInteger(data).add(new BigInteger("1")); ;
        char[] finalValue = bigInteger.toString().toCharArray();
        int[] result = new int[finalValue.length];
         for (int k = 0; k < finalValue.length; k++) {
            result[k] = Integer.parseInt(String.valueOf(finalValue[k]));
        }
        return result;
    }

    // Test multiple arrays
    public static void main(String[] args) {
        // squareSorted
       /* System.out.println(">>>>>>>>>>>>");
        int[] nums = {-4,-1,0,3,10};
        int[] result = sortedSquares(nums);
        System.out.println(Arrays.toString(result));*/

        //int[] nums = {1,2,3};
        //int[] nums = {4,3,2,1};
        int[] nums = {9,9,9,9};
        //List<Integer> result = findDisappearedNumbers(nums);
        // int result = dominantIndex(nums);
        //int result = pivotIndex(nums);
        int[] result = plusOne(nums);
        System.out.println(Arrays.toString(result));


        // Create multiple test cases
        List<TestCase> testCases = new ArrayList<>();

        // Add test cases: input array and expected output

        testCases.add(new TestCase(new int[]{2, 1, 1}, 2));
        testCases.add(new TestCase(new int[]{2, 2, 3, 1}, 1));
        testCases.add(new TestCase(new int[]{1, 2, 3, 4, 5}, 3));
        testCases.add(new TestCase(new int[]{2, 3, 1}, 1));
        testCases.add(new TestCase(new int[]{5, 4, 3, 2, 1}, 3));
        testCases.add(new TestCase(new int[]{-1, -5, 10, 100, 2}, 2));
        testCases.add(new TestCase(new int[]{-10, -5, -1}, -10));
        testCases.add(new TestCase(new int[]{42}, 42));
        testCases.add(new TestCase(new int[]{42, 34}, 42));
        testCases.add(new TestCase(new int[]{1, 2}, 2));

        testCases.add(new TestCase(new int[]{2, 1, 1}, 2));


        // Run all test cases
        //runTests(testCases);
    }

    // Test case class to store input and expected output
    static class TestCase {
        int[] input;
        int expectedOutput;

        TestCase(int[] input, int expectedOutput) {
            this.input = input;
            this.expectedOutput = expectedOutput;
        }
    }

    // Method to run all test cases
    public static void runTests(List<TestCase> testCases) {
        int passCount = 0;
        int totalTests = testCases.size();

        for (int i = 0; i < totalTests; i++) {
            TestCase test = testCases.get(i);

            try {
                int result = thirdMax(test.input);
                boolean passed = (result == test.expectedOutput);

                System.out.println("Test Case " + (i + 1) + ": " + (passed ? "✓ PASS" : "✗ FAIL"));
                System.out.println("  Input:    " + Arrays.toString(test.input));
                System.out.println("  Expected: " + test.expectedOutput);
                System.out.println("  Output:   " + result);
                System.out.println();

                if (passed) passCount++;
            } catch (Exception e) {
                System.out.println("Test Case " + (i + 1) + ": ✗ ERROR");
                System.out.println("  Input:    " + Arrays.toString(test.input));
                System.out.println("  Exception: " + e.getMessage());
                System.out.println();
            }
        }

        System.out.println("Summary: " + passCount + "/" + totalTests + " tests passed");
    }

}

