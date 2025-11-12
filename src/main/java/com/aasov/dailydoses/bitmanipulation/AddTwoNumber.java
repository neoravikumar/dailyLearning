package com.aasov.dailydoses.bitmanipulation;

public class AddTwoNumber {

    public static void main(String[] args) {
        String binary1 = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";  // 3 in decimal
        String binary2 = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";   // 1 in decimal

        // Convert binary strings to integers
       //     int num1 = Integer.parseInt(binary1, 2);
      //   int num2 = Integer.parseInt(binary2, 2);


        Integer num1 = Integer.parseInt(binary1);
        Integer num2 = Integer.parseInt(binary2);

        // Add the integers
       // int sum = num1 + num2;

        // Convert sum back to binary string
        //String binarySum = Integer.toBinaryString(sum);

        String resultString = Integer.toBinaryString(add(num1,num2));
        System.out.println(resultString);

        //System.out.println("Binary: " + binary1 + " + " + binary2 + " = " + binarySum);
        //System.out.println("Decimal: " + num1 + " + " + num2 + " = " + sum);
    }

    public static int add(int a, int b) {
        // Continue until there is no carry
        while (b != 0) {
            // Calculate carry
            int carry = a & b;

            // Sum without carry
            a = a ^ b;

            // Shift carry one position to the left
            b = carry << 1;
        }
        return a;
    }
}

