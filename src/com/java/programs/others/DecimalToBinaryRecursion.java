package com.java.programs.others;

import java.util.Stack;

/**
 * Created by sheik on 10/22/2017.
 */
public class DecimalToBinaryRecursion {

    Stack<Integer> binary = new Stack();

    public Stack<Integer>  DecimalToBinary(int num){

        if(num==0){
            return binary;
        }else{
            binary.push(num%2);
            return DecimalToBinary(num/2);
        }
    }

    public static void main(String a[]){
        DecimalToBinaryRecursion dtb = new DecimalToBinaryRecursion();
        Stack<Integer>  list = dtb.DecimalToBinary(25);
        while (!list.isEmpty()){
            System.out.print(list.pop()+" ");
        }


    }
}
