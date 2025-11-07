package com.code.may;

import java.util.Arrays;

public class Sorted2DMatrixFind {


    public static void main(String[] args){
        int [][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        int k=8;
        int element= findTheElement(matrix,k);
        System.out.println();
        System.out.println(element);
    }

    private static int findTheElement(int[][] matrix,int k) {
        int row  = matrix.length;
        int column = matrix[0].length;
        int[] arr = new int[row*column];
        int index=0;
        for(int i =0;i<row;i++){
            for(int j=0;j<column;j++){
                arr[index++] = matrix[i][j];
            }
        }
        Arrays.sort(arr);

        return arr[k-1];
    }
}
