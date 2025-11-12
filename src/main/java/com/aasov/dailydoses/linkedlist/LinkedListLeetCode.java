package com.aasov.dailydoses.linkedlist;

public class LinkedListLeetCode {

    public  static ListNode middleNode(ListNode head) {

        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            if (temp.next != null) {
                temp = head.next;
                count += 1;
            }
        }

        System.out.println(count);
        return temp;
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        ListNode middle = list.findMiddle();
        System.out.println("Middle element: " + middle.data); // Output: 3

        MyLinkedList list2 = new MyLinkedList();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(6);
        ListNode middle2 = list2.findMiddle();
        System.out.println("Middle element: " + middle2.data);
    }
}
