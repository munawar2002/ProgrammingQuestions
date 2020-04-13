package com.java.programs.others;

/**
 * Created by sheik on 8/14/2018.
 */
public class Solution {

    static class SinglyLinkedListNode {
        int data;
        private SinglyLinkedListNode next;

        public SinglyLinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList(){
            this.head=null;
            this.tail=null;
        }

        public void insertNode(int nodeData){
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if(this.head == null){
                this.head = node;
            }else {
                this.tail.next = node;
            }

            this.tail = node;
        }

        public void printList(){
            SinglyLinkedListNode node = head;
            while (node != null){
                System.out.print(node.data + " -> ");
                node = node.next;
            }
        }

//        SinglyLinkedListNode removeNodes(int x) {
//
//            //listHead = head;
//
//            SinglyLinkedListNode previous = null;
//            SinglyLinkedListNode next = null;
//
//            while (current != null){
//                next = current.next;
//
//                if(current.data > x){
//                    System.out.println("Big : "+ current.data);
//                    if(current.next == null){
//                        previous.next = null;
//                        current = next;
//                    }else {
//                        previous.next = next;
//                        current = next;
//                    }
//
//                }else {
//                    previous = current;
//                    current = next;
//
//                }
//
//
//            }
//
//            return lisHead;
//        }

    }



    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList= new SinglyLinkedList();
        singlyLinkedList.insertNode(3);
        singlyLinkedList.insertNode(4);
        singlyLinkedList.insertNode(5);
        singlyLinkedList.insertNode(2);
        singlyLinkedList.insertNode(7);
        singlyLinkedList.insertNode(1);
        singlyLinkedList.insertNode(8);




        singlyLinkedList.printList();
//        singlyLinkedList.removeNodes(4);
        singlyLinkedList.printList();

    }

}
