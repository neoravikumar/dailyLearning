package com.aasov.dailydoses.array;

import java.util.Arrays;

public class Problem1 {

    public static String addBinary(String binary1, String binary2) {
        long num1 = Long.parseLong(binary1, 2);
        long num2 = Long.parseLong(binary2, 2);
        long sum = num1 + num2;
        String result = Long.toBinaryString(sum);
        int[] resultArray = new int [result.length()];
        char[] sCharArray = result.toCharArray();
        int index =0;
        for(char k : sCharArray){
            int t = Integer.parseInt(String.valueOf(k));
            resultArray[index++]=t;
        }
        //return resultArray;
        return Long.toBinaryString(sum);
    }



    public static int[] middle(int[] array) {
        int[] resultArray;
        resultArray = new int[array.length - 2];

        for (int i = 1, j = 0; i <= array.length - 2; i++, j++) {
            resultArray[j] = array[i];
        }
        System.out.println(Arrays.toString(resultArray));
        return resultArray;
    }

    public static int sumDiagonalElements(int[][] array) {
        int sum = 0;
        /*for(int row=0;row<array.length;row++){
            for(int col=0;col<array[0].length;col++){
                if(row==col){
                    sum += array[row][col];
                }
            }
        }*/
        for (int i = 0; i < array.length; i++) {
            sum += array[i][i];
        }
        return sum;
    }

    public static int[] findTopTwoScores(int[] array) {
        int largest = Integer.MIN_VALUE;
        int sL = Integer.MIN_VALUE;
        int[] result = new int[2];
        for (int j : array) {
            if (j > largest) {
                largest = j;
            }
        }

        for (int j : array) {
            if (j != largest) {
                if (j > sL) {
                    sL = j;

                }
            }
        }
        result[0] = largest;
        result[1] = sL;
        return result;
    }

    public static int removeDuplicates(int[] nums) {

        int start = 0, next= 1, n = nums.length;
        for(;next<n;next++){
            if(nums[next]!=nums[start]){
                start++;
                nums[start]=nums[next];
            }
        }
        return start + 1;
    }

    public static void main(String[] args) {
        //int[] input = {1,2,3,4};
        //Problem1.middle(input);

        /*int[][] mArray = {{1,2,3},{4,5,6},{7,8,9}};
        int result = Problem1.sumDiagonalElements(mArray);
        System.out.println(result);*/


        //int[] nums = {1, 1, 2};
       /* int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int result = Problem1.removeDuplicates(nums);
        System.out.println("The Number of Duplicate is :" + result);
        System.out.println("The result ArrayIs:" + Arrays.toString(nums));*/

        String binary1 = "1010";
        String binary2 = "1011";
        String result = addBinary(binary1, binary2);
        int[] resultArray = new int [result.length()];
        char[] sCharArray = result.toCharArray();
        int index =0;
        for(char k : sCharArray){
            int t = Integer.parseInt(String.valueOf(k));
            resultArray[index++]=t;
        }
        System.out.println(Arrays.toString(resultArray));
        //int[] result2 = result.toCharArray();
        System.out.println("The sum of " + binary1 + " and " + binary2 + " is: " + result); // Output: 10101


    }

}
