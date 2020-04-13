package com.java.programs.others;

/**
 * Created by sheik on 5/1/2018.
 */
public class Palindrome {
    public static boolean isPalindrome(String s) {
        if (null == s || "".equals(s.trim())) {
            return false;
        }

        /*
          Definition: A palindrome is a string that reads the same forward and backward.
          For example, "abcba" is a palindrome, "abab" is not.
          Please implement this method to
          return true if the parameter is a palindrome and false otherwise.
         */
        String myStr = s.trim();
        for (int i = 0; i < (myStr.length() / 2); i++) {
            if (myStr.charAt(i) != myStr.charAt(myStr.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}
