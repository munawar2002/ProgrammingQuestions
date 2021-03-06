package com.java.programs.leetcode;

public class SumTwoNumbersLinkList {

    ListNode head1;
    ListNode head2;
    ListNode head3;

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //ListNode reverseL1 = reverseLinkList(l1);
        printLinklist(l1);
        //ListNode reverseL2 = reverseLinkList(l2);
        printLinklist(l2);

        head3 = sumLinkList(l1, l2);
        printLinklist(head3);

        return head3;
    }

    private ListNode sumLinkList(ListNode reverseL1, ListNode reverseL2) {
        ListNode curr1 = reverseL1;
        ListNode curr2 = reverseL2;

        int carry = 0;
        while (curr1 != null || curr2 != null) {

            int curr1Value = 0;
            if (curr1 != null) {
                curr1Value = curr1.val;
                curr1 = curr1.next;
            }

            int curr2Value = 0;
            if (curr2 != null) {
                curr2Value = curr2.val;
                curr2 = curr2.next;
            }

            int sum = curr1Value + curr2Value + carry;
            if (sum > 9) {
                carry = firstDigit(sum);
                sum = sum % 10;

            } else {
                carry = 0;
            }

            head3 = createNode(head3, sum);
        }

        if(carry != 0) {
            head3 = createNode(head3, carry);
        }

        return head3;
    }

    int firstDigit(int num) {
        if (num / 10 == 0)
            return num;
        return firstDigit(num / 10);

    }

    private ListNode reverseLinkList(ListNode l1) {

        ListNode currNode = l1;
        ListNode prev = null;
        ListNode next;

        while (currNode != null) {
            next = currNode.next;
            currNode.next = prev;
            prev = currNode;
            currNode = next;
        }

        l1 = prev;
        return l1;
    }


    private ListNode createNode(ListNode head, long number) {

        ListNode node = new ListNode((int) number);

        if (head == null) {
            head = node;
        } else {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
        return head;
    }

    private void createNode1(ListNode head, long number) {
        head1 = createNode(head, number);
    }

    private void createNode2(ListNode head, long number) {
        head2 = createNode(head, number);
    }


    private void printLinklist(ListNode node) {
        ListNode currNode = node;

        while (currNode != null) {
            System.out.print(currNode.val + " ");
            currNode = currNode.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        SumTwoNumbersLinkList test = new SumTwoNumbersLinkList();

        test.createNode1(test.head1, 1);
        test.createNode1(test.head1, 8);
        test.createNode2(test.head2, 0);

        test.addTwoNumbers(test.head1, test.head2);

    }

}
