/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop01;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Workshop01 {
    public static void main(String[] args) {
        int rows;
        int cols;
        int matrix[][];
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        rows = sc.nextInt();
        System.out.print("Enter number of cols: ");
        cols = sc.nextInt();
        matrix = new int[rows][cols];
        System.out.println("Enter the matrix");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("m["+i+"]["+j+"]=");
                matrix[i][j]=sc.nextInt();
            }
        }
        System.out.println("Matrix inputed:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println("");
        }
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum=sum+matrix[i][j];
            }
        }
        System.out.println("");
        System.out.println("Sum:"+sum);
        System.out.println("Average:"+(float)sum/(rows*cols));
    }
    
}
