package aeiou;

import java.util.*;

public class TransposeMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter rows:");
        int rows = sc.nextInt();

        System.out.println("Enter columns:");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];

        System.out.println("Enter matrix elements:");
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();

            }
            System.out.println();
        }
        System.out.println(matrix.toString()+ " "); 

        // Transpose matrix
        int[][] transpose = new int[cols][rows];
        System.out.print("The Reverse Matrix is "); 
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                transpose[j][i] = matrix[i][j];
              

                System.out.print(transpose[j][i] + " "); 
            }
            System.out.println();

        }

        // Print transpose
        System.out.println("Transpose Matrix:");
        for(int i = 0; i < cols; i++) {
            for(int j = 0; j < rows; j++) {
                System.out.print(transpose[i][j] + " ");
            }
            System.out.println();
        }
    }
}