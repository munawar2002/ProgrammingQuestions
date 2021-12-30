package com.java.programs.leetcode;

//  Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class RotateLinkedList {
    public ListNode rotateRight(ListNode head, int k) {

        if (k == 0 || head == null) {
            return head;
        }

        ListNode temp = head;
        ListNode temp2 = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            if (count != 0) {
                temp2 = temp2.next;
            }
            count++;
        }


        int rotation = k;

        if (count < k) {
            rotation = k % count;
        }

        if (count == 1 || count == rotation) {
            return head;
        }


        temp = head;
        ListNode kTemp = head;
        for (int i = 0; i < count - rotation - 1; i++) {
            kTemp = kTemp.next;
        }

        temp2.next = head;

        ListNode nextNode = kTemp.next;

        kTemp.next = null;
        head = nextNode;

        return head;
    }
}