package com.java.programs.others;

/**
 * Created by sheik on 10/28/2017.
 */
public class ArthmeticMean {

    public static void main(String[] args) {

        int[] array = {1,2,3,4,5,6};

        double sum=0;
        for(int num : array){
            sum+=num;
        }

        double average = sum/array.length;

        System.out.println("Sum = "+array.length);
        System.out.println("Average = "+average);


    }
}
