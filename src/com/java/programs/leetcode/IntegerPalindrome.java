package com.java.programs.leetcode;

public class IntegerPalindrome {

    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }

        int reverse = getReverse(x);

        return reverse == x;
    }

    private int getReverse(int number) {
        int reverse = 0;
        while(number !=0){
            reverse = (reverse*10) + number % 10;
            number /= 10;
        }
        return reverse;
    }

    public static void main(String[] args) {
        IntegerPalindrome test = new IntegerPalindrome();
        System.out.println(test.isPalindrome(121321));

    }

}
