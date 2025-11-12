package com.aasov.dailydoses.array;

public class SearchArray {
    public static void main(String[] args) {
        //int inputArray[] = {-2, 0, 10, -19, 4, 6, -8}; //false
        //int inputArray[] = {10,2,5,3}; //true
        //int inputArray[] = {0,0}; //true
        int inputArray[] = {-20, 8, -6, -14, 0, -19, 14, 4};
        SearchArray searchArray = new SearchArray();
        boolean result = searchArray.checkIfExist(inputArray);
        System.out.println(result);
    }

    public boolean checkIfExist(int[] arr) {
        if (arr.length >= 2 && arr.length <= 500) {
            for (int i = 0; i < arr.length; i++) {
                int input = arr[i];
                if (input >= -1000 && input <= 1000) {
                    for (int k = 0; k < arr.length; k++) {
                        if ((input == arr[k] * 2) && i != k) {
                            return true;
                        }
                    }
                }

            }

        }
        return false;
    }

}
