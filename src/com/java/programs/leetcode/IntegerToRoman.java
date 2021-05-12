package com.java.programs.leetcode;

import java.util.TreeMap;

public class IntegerToRoman {

    private static TreeMap<Integer, String> romanNumerals = new TreeMap<>();

    static{
        romanNumerals.put(1,"I");
        romanNumerals.put(4,"IV");
        romanNumerals.put(5,"V");
        romanNumerals.put(9,"IX");
        romanNumerals.put(10,"X");
        romanNumerals.put(40,"XL");
        romanNumerals.put(50,"L");
        romanNumerals.put(90,"XC");
        romanNumerals.put(100,"C");
        romanNumerals.put(400,"CD");
        romanNumerals.put(500,"D");
        romanNumerals.put(900,"CM");
        romanNumerals.put(1000,"M");
    }

    public String intToRoman(int num) {
        int floorValue = romanNumerals.floorKey(num);

        if(num == floorValue){
            return romanNumerals.get(floorValue);
        }
        num -= floorValue;
        return romanNumerals.get(floorValue) + intToRoman(num);
    }

    public String intToRomanSolution2(int num) {

        String[] thousands = {"","M","MM","MMM","MMMM","MMMMM","MMMMMM","MMMMMMM","MMMMMMMM","MMMMMMMMM"};
        String[] hundreds = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] tens = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] units = {"","I","II","III","IV","V","VI","VII","VIII","IX"};

        return thousands[num/1000]+
                hundreds[(num%1000)/100]+
                tens[(num%100)/10]+
                units[num%10];
    }


    public static void main(String[] args) {
        IntegerToRoman test = new IntegerToRoman();
//        for (int i = 1;i<256;i++) {
//            System.out.println("i="+i+" -> "+test.intToRoman(i));
//        }
        System.out.println(test.intToRoman(1994));
        System.out.println(test.intToRoman(1995));

    }
}
