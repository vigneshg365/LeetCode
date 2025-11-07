package com.code.may;

public class LargestLocalValuesMatrix {

    public static void main(String[] args){
        int[][] grid = {{9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}};
        int[][] ans = largestLocal(grid);
    }


    public static int[][] largestLocal(int[][] grid) {

    int row = grid.length-1;
    int column = grid[0].length-1;
    int index = 0;
    int[] result = new int[row+1];
    for(int i=0;i<=row;i++){
        int max=0;
        for(int j=0;j<=column;j++){
          if(grid[i][j]>max)
              max = grid[i][j];
        }
        result[index++] = max;
    }
    for(int i=0;i<result.length;i++)
        System.out.print(result[i]+" ");


        return grid;
    }
}
