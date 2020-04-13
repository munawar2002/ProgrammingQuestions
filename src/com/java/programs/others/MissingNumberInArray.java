package com.java.programs.others;

/**
 * Created by sheik on 11/15/2017.
 */

/**
 * If n = 8, then array ‘a’ will have 7 elements in the range from 1 to 8.
 * For example {1, 4, 5, 3, 7, 8, 6}. One number will be missing in ‘a’ (2 in this case).
 * You have to find out that missing number.
 */

import java.util.Arrays;

/**
 * Solution:
 * Step 1 : First we find out sum of ‘n’ numbers by using formula n*(n+1)/2.
 * Step 2 : Then we will find sum of all elements of array ‘a’.
 * Step 3 : Missing_Number = (Sum of 1 to ‘n’ numbers) – (Sum of elements of array ‘a’)
 */
public class MissingNumberInArray {

        //Method to calculate sum of 'n' numbers

        static int sumOfNnumbers(int n){
            return (n * (n+1))/ 2;
        }

        public static void main(String[] args)
        {
            int n = 8;

            int[] a = {1, 4, 5, 3, 7, 8, 6};

            //Step 1

            int sumOfNnumbers = sumOfNnumbers(n);

            //Step 2

            int sumOfElements = Arrays.stream(a).sum();

            //Step 3
            int missingNumber = sumOfNnumbers - sumOfElements;

            System.out.println("Missing Number is = "+missingNumber);
        }
    }
