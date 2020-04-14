package com.java.programs;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Question: https://www.interviewbit.com/problems/matrix-median/

 * Created by Munawar on 4/15/2020.
 */
public class MatrixMedian {

    public static double matrixMedian(int[][] arrays){

        int[] mergedArray = getMergedSortedArray(arrays);

        double median = 0;
        if(mergedArray.length%2==1){
            median = mergedArray[mergedArray.length/2];
        }else{
            median = ((double)mergedArray[mergedArray.length/2]+(double)mergedArray[(mergedArray.length/2)-1])/2;
        }

        return  median;
    }

    private static int[] getMergedSortedArray(int[][] arrays) {
        int[] mergedArray = new int[arrays.length*arrays[0].length];

        Map<Integer,Integer> mapOfIndexes = new HashMap<>();

        IntStream.range(0,arrays.length).forEach(i->mapOfIndexes.put(i,0));

        int count=0;
        for(int i=0; i<mergedArray.length; i++){

            int min=Integer.MAX_VALUE;
            int minIndex = Integer.MAX_VALUE;
            for(int j=0; j<arrays.length;j++){
                if(mapOfIndexes.get(j)<arrays[j].length && arrays[j][mapOfIndexes.get(j)]<min){
                    min = arrays[j][mapOfIndexes.get(j)];
                    minIndex = j;
                }
            }

            mapOfIndexes.put(minIndex,mapOfIndexes.get(minIndex)+1);
            mergedArray[count] = min;
            System.out.print(mergedArray[count++]+" ");
        }
        return mergedArray;
    }


    public static void main(String a[]) {
        int[][] A = {{1,3,5,7},{2,7,7,9},{3,6,7,8}};

        System.out.println();
        System.out.println(MatrixMedian.matrixMedian(A));

        //System.out.println(Testing.solution(30, 0));
    }

}
