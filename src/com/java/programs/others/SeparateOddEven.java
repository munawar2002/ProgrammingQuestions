package com.java.programs.others;

/**
 * Created by sheik on 11/14/2017.
 */
public class SeparateOddEven {

    public static void swap(int[] arr, int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void doSeparateOddEven(int[] arr){
        int i=0; int j = arr.length-1;

        while(i < j) {

            if ((arr[i] % 2 == 0) && (arr[j] % 2 == 1)) {
                SeparateOddEven.swap(arr, i, j);
                i++;
                j--;
            }

            if ((arr[i] % 2 == 1) && (arr[j] % 2 == 1)) {
                i++;
            }

            if ((arr[i] % 2 == 0) && (arr[j] % 2 == 0)) {
                j--;
            }

            if ((arr[i] % 2 == 1) && (arr[j] % 2 == 0)) {
                i++;
                j--;
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {5, 12, 3, 21, 8, 7, 19, 102, 201};
        int[] arr2 = {202, 102, 3, 21, 8, 7, 19, 13, 5};
        int[] arr3 = {202, 13, 3, 21, 8, 7, 19, 102, 5};
        int[] arr4 = {6, 13, 3, 21, 8, 7, 19, 102, 202,312};

        SeparateOddEven.doSeparateOddEven(arr);
        for(int a : arr){
            System.out.print(a + " -> ");
        }
        System.out.println();
        SeparateOddEven.doSeparateOddEven(arr2);
        for(int a : arr2){
            System.out.print(a + " -> ");
        }
        System.out.println();
        SeparateOddEven.doSeparateOddEven(arr3);
        for(int a : arr3){
            System.out.print(a + " -> ");
        }
        System.out.println();
        SeparateOddEven.doSeparateOddEven(arr4);
        for(int a : arr4){
            System.out.print(a + " -> ");
        }
    }
}
