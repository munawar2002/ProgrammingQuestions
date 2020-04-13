package com.java.programs.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

    private static Map<String,Integer> romanNumerals = new HashMap<>();

    static{
        romanNumerals.put("I" ,1);
        romanNumerals.put("IV",4);
        romanNumerals.put("V" ,5);
        romanNumerals.put("IX",9);
        romanNumerals.put("X",10   );
        romanNumerals.put("XL",40);
        romanNumerals.put("L",50);
        romanNumerals.put("XC",90);
        romanNumerals.put("C",100);
        romanNumerals.put("CD",400);
        romanNumerals.put("D",500);
        romanNumerals.put("CM",900);
        romanNumerals.put("M",1000);
    }

    public int romanToInt(String s) {
        return romanToInt(s,0);
    }

    private int romanToInt(String s, int result){

        if(s.isEmpty()){
            return result;
        }

        Integer twoCharValue = null;
        int stringMovingCount = 1;
        if(s.length()>1){
            twoCharValue = romanNumerals.get(s.charAt(0)+""+s.charAt(1));
        }

        int value = romanNumerals.get(s.charAt(0)+"");

        if(twoCharValue != null){
            value = twoCharValue;
            stringMovingCount =2;
        }

        return romanToInt(s.substring(stringMovingCount),value+result);
    }

    public static void main(String[] args) {
        RomanToInt test = new RomanToInt();
        System.out.println(test.romanToInt("MCMXCIV"));

    }
}
