package com.java.programs.others;

/**
 * Created by sheik on 10/22/2017.
 */
public class MySwapingTwoNumbers {
    public static void main(String a[]){
        int x = 10;
        int y = 20;
        System.out.println("Before swap:");
        System.out.println("x data: "+x);
        System.out.println("y data: "+y);
        x = x+y;
        y=x-y;
        x=x-y;
        System.out.println("After swap:");
        System.out.println("x data: "+x);
        System.out.println("y data: "+y);
    }
}
