package com.aasov.dailydoses.linkedlist;

public class ListNode {
    int data;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.data = val;
    }

    ListNode(int val, ListNode next) {
        this.data = val;
        this.next = next;
    }
}

