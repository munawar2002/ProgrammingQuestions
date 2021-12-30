package com.java.programs.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> spirals = new ArrayList<>();

        Direction dir = new Direction(0,1);

        int i=0,j=0;
        makeMove(matrix,i,j,dir,spirals,0);
        return spirals;
    }

    private void makeMove(int[][] matrix, int i,int j,
                          Direction dir, List<Integer> spirals, int count){

        count = markMatrix(matrix,i,j, spirals,count);

        if (count ==1) return;

        int nextI = i+dir.row;
        int nextJ = j+dir.col;

        if(!withinBoundries(matrix,nextI,nextJ) ||
                matrix[nextI][nextJ] == 1000){
            dir.takeRight();
        }

        makeMove(matrix,i+dir.row,j+dir.col,dir,spirals,count);


    }

    private boolean withinBoundries(int[][] matrix, int i,int j){
        return (i >=0 && i< matrix.length &&
                j >=0 && j< matrix[0].length);
    }

    private int markMatrix(int[][] matrix, int i, int j,
                           List<Integer> spirals, int count){

        if(withinBoundries(matrix,i,j) && matrix[i][j] != 1000){
            spirals.add(matrix[i][j]);
            matrix[i][j] = 1000;
        } else {
            return count + 1;
        }

        return 0;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix2 = {{1}};

        SpiralMatrix s = new SpiralMatrix();
        System.out.println(s.spiralOrder(matrix));
        System.out.println(s.spiralOrder(matrix2));
    }

}
