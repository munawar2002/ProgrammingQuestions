package com.java.programs.others;

import java.util.Queue;
import java.util.Stack;

public class QueueUsingStacks {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    boolean enqueue(int num){
        stack1.push(num);
        return true;
    }

    Integer dequeue(){

        if(stack1.isEmpty() && stack2.isEmpty()){
           return null;
        }

        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }




    public static void main(String[] args) {

        QueueUsingStacks obj = new QueueUsingStacks();

        obj.enqueue(1);
        obj.enqueue(2);
        System.out.println(obj.dequeue());
        obj.enqueue(3);
        obj.enqueue(4);
        System.out.println(obj.stack1);
        System.out.println(obj.stack2);
//        System.out.println(obj.dequeue());
//        System.out.println(obj.dequeue());
//        System.out.println(obj.stack1.isEmpty());
//        System.out.println(obj.stack2.isEmpty());
    }

}
