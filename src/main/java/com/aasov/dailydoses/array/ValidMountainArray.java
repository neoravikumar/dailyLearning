package com.aasov.dailydoses.array;

public class ValidMountainArray {

    public static void main(String[] args) {
        //int[] input= {0,3,2,1};
        //int[] input= {0,1,2,3,4,8,9,10,11,12,11};
        int[] input= {4,20,32,45,49,45,31,21,20,16,11,8};
        //int[] input = {2,1};
        //int[] input = {3,2,1};
        //int[] input = {3,5,5};
        //int[] input = {2,0,2};
        //int[] input = {0,1,2,1,2};


        boolean result = new ValidMountainArray().validMountainArray(input);
        System.out.println(result);
    }

    public boolean validMountainArray(int[] arr) {
        int length = arr.length;
        int increasing=0;
        int decresing=0;

        boolean isInc= false;
        boolean isdec= false;


        if(length<3){
            return false;
        }

        if(arr[0]>arr[1]){
            return false;
        }

        for(int i =0,j=1;i<length-1;i++,j++){
            // edge case
            if(arr[j]>arr[i]){
                increasing++;
            } else if (arr[i]>arr[j]) {
                increasing=-1;
                decresing+=1;
            }
        }

        if(increasing==-1 && decresing>=1){
           return Boolean.TRUE;
        }

        return false;
    }
}
