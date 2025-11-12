package com.aasov.dailydoses.array;

public class ProblemSet1 {

    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int[] result = new int[2];
        if(n<=1){
            return result;
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(numbers[i]+numbers[j]==target){
                    result[0]=i;
                    result[1]=j;
                    return result;
                }
            }
        }

        return  result;
    }
}
