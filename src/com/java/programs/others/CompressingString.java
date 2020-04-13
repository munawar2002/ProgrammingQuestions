package com.java.programs.others;

/**
 * Created by sheik on 8/14/2018.
 */
public class CompressingString {

    static String compressedString(String message) {

        StringBuilder s = new StringBuilder();
        int count = 0;
        s.append(message.charAt(0));
        for(int i =1 ; i<message.length(); i++){

            if(message.charAt(i-1) != message.charAt(i)){
                if(count > 0){
                    s.append(count+1);
                }
                s.append(message.charAt(i));
                count = 0;
            }else {
                count++;

            }
        }

        if(count > 0){
            s.append(count+1);
        }

        return s.toString();
    }


    public static void main(String[] args) {
        System.out.println(CompressingString.compressedString("abcccbbaaggggk"));
        System.out.println(CompressingString.compressedString("abcccbbbbbbbbbbuusazzz"));

    }
}
