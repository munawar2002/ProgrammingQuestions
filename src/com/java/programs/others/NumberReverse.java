package com.java.programs.others;

/**
 * Created by sheik on 10/22/2017.
 */
public class NumberReverse {

    public int reverseNumber(int number){
        int reverse = 0;
        while (number !=0){
            reverse = (reverse*10) + (number%10);
            number = number/10;
        }
        return reverse;
    }

    public int reverseNumberRecursion(int number,int reverse){
        if(number<1){
            return reverse;
        }

        reverse = (reverse*10) + (number%10);
        number/=10;

        return reverseNumberRecursion(number,reverse);
    }

    public static void main(String a[]){
        NumberReverse nr = new NumberReverse();
        System.out.println("Result: "+nr.reverseNumber(17868));
        System.out.println("Result: "+nr.reverseNumberRecursion(17868,0));

    }
}
