package com.java.programs.others;

/**
 * Created by sheik on 10/22/2017.
 */
public class ReverseLinklist {

    private Node head;

    public void addNode(int value){

        Node newNode = new Node();
        newNode.setValue(value);

        Node tmp = head;

        while(true){
            if(tmp == null){
                head = newNode;
                break;
            }else if(tmp.getNextRef() == null){
                tmp.setNextRef(newNode);
                break;
            }else{
                tmp = tmp.getNextRef();
            }
        }
    }

    public void print(){
        Node tmp = head;

        while (true){
            if(tmp==null){
                break;
            }
            System.out.println(tmp.getValue());
            tmp=tmp.getNextRef();
        }
    }

    /**
     * To reverse a linkList. Alter the pointer. Set current pointers to prev.
     * next = current of next
     * current point to back
     * prev set current
     * current set next
     */
    public void reverse(){

        Node next;
        Node current = head;
        Node prev = null;

        while (current != null){
            next = current.getNextRef();
            current.setNextRef(prev);
            prev=current;
            current=next;
        }
        head=prev;
    }


    public static void main(String[] args) {
        ReverseLinklist ll = new ReverseLinklist();
        ll.addNode(1);
        ll.addNode(10);
        ll.addNode(3);
        ll.addNode(5);
        ll.addNode(7);

        ll.print();
        ll.reverse();
        System.out.println();
        ll.print();

    }
}

class Node {
    int value;
    private Node nextRef;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNextRef() {
        return nextRef;
    }

    public void setNextRef(Node nextRef) {
        this.nextRef = nextRef;
    }
}