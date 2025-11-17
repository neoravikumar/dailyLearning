package com.aasov.dailydoses.array.Aug2025.array;

import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        int[] input = {9,6,4,2,3,5,7,0,1};
        //missingNumber(input);
        System.out.println(missingNumber(input));
        int[] result = getConcatenation(input);
        System.out.println(Arrays.toString(result));
    }
    public static int missingNumber(int[] nums) {
        int N = nums.length;
        int totalSum = (N*(N+1))/2;
        int arraySum = Arrays.stream(nums).sum();
        return totalSum-arraySum;
    }

    // Leet code https://leetcode.com/problems/concatenation-of-array/submissions/1828506159/
    public static int[] getConcatenation(int[] nums) {
        int N = nums.length;
        int[] newArray = new int[N*2];
        int k=0;
        for(int a:nums){
            newArray[k]=a;
            newArray[N + k]=a;
            k=k+1;
        }
        return newArray;
    }
}
