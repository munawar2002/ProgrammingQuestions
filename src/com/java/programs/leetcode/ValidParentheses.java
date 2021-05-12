package com.java.programs;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Munawar on 4/16/2020.
 */
public class ValidParentheses {

    public boolean isValid(String s) {

        if(s.length()%2==1){
            return false;
        }

        Map<Character,Character> map = new HashMap<>();

        map.put('{','}');
        map.put('(',')');
        map.put('[',']');

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length();i++){

            if(!map.containsKey(s.charAt(i))){
                if(stack.isEmpty() || s.charAt(i) != map.get(stack.pop())){
                    return false;
                }
            }else{
                stack.add(s.charAt(i));
            }
        }

        return stack.isEmpty();
    }

    public static void main(String a[]) {
        ValidParentheses test = new ValidParentheses();
        System.out.println(test.isValid("{[]}"));
    }

}
