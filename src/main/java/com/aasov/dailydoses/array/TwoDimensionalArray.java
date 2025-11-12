package com.aasov.dailydoses.array;

import java.util.Arrays;

public class TwoDimensionalArray {

    public static int[] findDiagonalOrder(int[][] mat) {
        if (mat.length == 0) return new int[0];
        int r = mat.length, c= mat[0].length;
        int[] result = new int[r * c];
        int row = 0, col = 0, d = 1;

        for (int i = 0; i < r * c; i++) {
            result[i] = mat[row][col];
            row -= d;
            col += d;

            if (row >= r) { row = r - 1; col += 2; d = -d;}
            if (col >= c) { col = c - 1; row += 2; d = -d;}
            if (row < 0) { row = 0; d = -d;}
            if (col < 0) { col = 0; d = -d;}
        }
        return result;
    }

    public static void rotateMatrix(int[][] matrix) {
        int len = matrix.length;

        // transpose of Matrix
        for (int row = 0; row < len; row++) {
            for (int column = row; column < matrix[0].length; column++) {
                int temp = matrix[row][column];
                matrix[row][column] = matrix[column][row];
                matrix[column][row] = temp;
            }
        }
        // reverse the row
        for (int row = 0; row < len; row++) {
            int leftColumn = 0, rightColumn = matrix.length - 1;
            while (leftColumn < rightColumn) {
                int temp = matrix[row][leftColumn];
                matrix[row][leftColumn] = matrix[row][rightColumn];
                matrix[row][rightColumn] = temp;

                leftColumn += 1;
                rightColumn -= 1;
            }
        }
    }


    public static void main(String[] args) {
        int arr[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        System.out.println("Original Matrix:");
        printMatrix(arr);

        //rotateMatrix(arr);
        int[] result =  findDiagonalOrder(arr);

        System.out.println(Arrays.toString(result));

        System.out.println("Rotated Matrix (90 degrees clockwise):");
        printMatrix(arr);

    }

    // Helper method to print the matrix
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
