package com.java.programs.others;

/** Write a program to reverse a string using recursive methods.
 You should not use any string reverse methods to do this
 * Created by sheik on 10/22/2017.
 */
public class StringRecursiveReversal {

    String reverse = "";
    public String reverseString(String str){

        if(str.length()==1){
            return str;
        }else {
            reverse+= str.charAt(str.length()-1) + reverseString(str.substring(0,str.length()-1));
            return reverse;
        }
    }


    public static void main(String a[]){
        StringRecursiveReversal srr = new StringRecursiveReversal();
        String str="Java2novice";
        System.out.println("Result: "+srr.reverseString(str));
    }

}
