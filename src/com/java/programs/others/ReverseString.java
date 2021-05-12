package com.java.programs.others;

import java.util.Arrays;
import java.util.Stack;

public class ReverseString {

    public static String reverseStringWithStack(String str){

        Stack<Character> stack = new Stack<>();
        for(Character c : str.toCharArray()){
            stack.push(c);
        }
        StringBuilder s = new StringBuilder();
        while (!stack.isEmpty()){
            s.append(stack.pop());
        }
        return s.toString();
    }

    public static String reverseString(String str){
        char[] strArray = str.toCharArray();

        int left = 0, right = str.length()-1;

        while (left < right){
            char temp = strArray[right];
            strArray[right] = strArray[left];
            strArray[left] = temp;
            left++;
            right--;
        }

        return Arrays.toString(strArray);
    }

    public static void main(String[] args) {
        String str = "ReverseMe";
        System.out.println(str);
        System.out.println(ReverseString.reverseString(str));
        System.out.println(ReverseString.reverseStringWithStack(str));
    }


}
