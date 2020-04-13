package com.java.programs.leetcode;

public class StringToNumberATOI {
    public int myAtoi(String str) {

        if(str.isEmpty() || str.trim().isEmpty()){
            return 0;
        }

        str = str.trim();
        boolean positiveSign=true;
        boolean isFirstChar = true;
        long number=0;
        for(int i = 0; i < str.length(); i++){
            boolean isPlusOrMinus = isPlusMinus(str.charAt(i));

            if(isFirstChar && (!isPlusOrMinus && !Character.isDigit(str.charAt(i)))){
                return 0;
            }

            if(!isFirstChar && !Character.isDigit(str.charAt(i))){
                number = !positiveSign ? number*-1 : number;
                return (int) number;
            }

            if(isPlusOrMinus){
                if(str.charAt(i) == 45){
                    positiveSign = false;
                }
                isFirstChar=false;
                continue;
            }

            number = number * 10 + Character.getNumericValue(str.charAt(i));

            if(number > Integer.MAX_VALUE && positiveSign){
                return Integer.MAX_VALUE;
            }else if(number > Integer.MAX_VALUE){
                return Integer.MIN_VALUE;
            }

            isFirstChar = false;
        }

        number = !positiveSign ? number*-1 : number;
        return (int) number;
    }

    private boolean isPlusMinus(char digit) {
        return (digit == 43 || digit == 45);
    }


    public static void main(String[] args) {
        StringToNumberATOI test = new StringToNumberATOI();
        System.out.println(test.myAtoi("+-2"));
    }
}
