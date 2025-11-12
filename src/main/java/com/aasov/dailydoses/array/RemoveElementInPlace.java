package com.aasov.dailydoses.array;

import java.util.Arrays;

public class RemoveElementInPlace {
    public static void main(String[] args) {
        int[] input = {0, 1, 2, 2, 3, 0, 4, 2, 2};
        //int[] input = {6, 2};
        //int[] input = {3,2,2,3};
        int result = removeElement(input, 2);
        System.out.println(result);

    }

    public static int removeElement(int[] nums, int val) {
        int fp=0,np=0;
        int len = nums.length;
        for(int i=0;i<len;i++,np++){
            if(nums[np]!=val){
                nums[fp]=nums[np];
                fp+=1;
            }
        }
        return fp;
    }
}
