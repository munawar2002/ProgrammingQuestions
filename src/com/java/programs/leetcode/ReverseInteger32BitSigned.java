package com.java.programs.leetcode;

public class ReverseInteger32BitSigned {

    public int reverse(int x) {

        long reverse = 0;
        while(x != 0){
            reverse = (reverse * 10) + x%10;
            x /= 10;
        }

        if(reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE){
            return 0;
        }

        return (int)reverse;
    }

    public static void main(String[] args) {
        ReverseInteger32BitSigned test = new ReverseInteger32BitSigned();
        System.out.println(test.reverse(-2147483648));
    }
}
