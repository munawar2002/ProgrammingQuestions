package com.java.programs.leetcode;

public class ZigZagConversion {

    public String convert(String s, int numRows) {
        if(s.isEmpty()){
            return "";
        }

        if(numRows ==1){
            return s;
        }

        int jumps = numRows + (numRows-2);

        StringBuilder sb = new StringBuilder("");
        int j=0;
        for(int row=0; row<numRows && row < s.length(); row++) {
            int currIndex = row;

            sb.append(s.charAt(currIndex));
            //System.out.print(s.charAt(currIndex));

            if(row>0 && row<numRows-1){
                j+=2;
            }

            while(currIndex < s.length()){

                currIndex += jumps;

                if(row>0 && row<numRows-1){
                    currIndex -=j;
                    //   System.out.print(s.charAt(currIndex));
                    if(currIndex <s.length()) {
                        sb.append(s.charAt(currIndex));
                    }
                    currIndex +=j;
                }

                if(currIndex <s.length()){
                    sb.append(s.charAt(currIndex));
                    // System.out.print(s.charAt(currIndex));
                }
            }
        }


        return sb.toString();
    }


    public static void main(String[] args) {
        ZigZagConversion test = new ZigZagConversion();
        String result = test.convert("PAYPALISHIRING",3);
        System.out.println(result);
    }

}
