
package com.aasov.dailydoses.array;

import java.util.Arrays;

public class Sortarraybyparity {


    public static void main(String[] args) {
        int[] input = {0,2,1};
        int[] result = new Sortarraybyparity().sortArrayByParityMethod(input);
        System.out.println(Arrays.toString(result));

    }

    public int[] sortArrayByParityMethod(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums;
        }
        if(length==2){
            if(nums[0]==1 && nums[1]==0){
                nums[1]=1;
                nums[0]=0;
                return nums;
            }
            if(nums[0]==0){
                return nums;
            }
        }


        // Brute Force
        int[] evenArray = new int[length];
        int[] oddArray = new int[length];
        Arrays.fill(oddArray, Integer.MIN_VALUE);
        Arrays.fill(evenArray, Integer.MIN_VALUE);
        for (int i = 0, k = 0, j = 0; i < length; i++) {
            if (nums[i] % 2 == 0) {
                evenArray[k] = nums[i];
                k++;
            } else {
                oddArray[j] = nums[i];
                j++;
            }
        }

            int evenNumberCount=0;
            if (evenArray.length > 0) {
                for (int k = 0; k < evenArray.length; k++) {
                    if(evenArray[k]>=0){
                        nums[k] = evenArray[k];
                        evenNumberCount++;
                    }
                }
            }
            if (oddArray.length > 0) {
                for (int k = evenNumberCount, j = 0; k < nums.length; k++) {
                    if (oddArray[j] > 0) {
                        nums[k] = oddArray[j];
                        j++;
                    }

                }
            }

        return nums;
    }
}