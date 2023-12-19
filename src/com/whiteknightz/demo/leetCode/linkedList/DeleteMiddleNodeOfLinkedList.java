package com.whiteknightz.demo.leetCode.linkedList;

import com.whiteknightz.demo.leetCode.ListNode;

import java.util.Objects;

/*
    You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.

    The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, where ⌊x⌋
    denotes the largest integer less than or equal to x.

    For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.
 */

public class DeleteMiddleNodeOfLinkedList {
    public static ListNode deleteMiddle(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }
        ListNode dummy=new ListNode(0);
        dummy.next = head;

        ListNode slower = dummy;
        ListNode faster = dummy;

        slower = slower.next;
        faster = faster.next;

        while (faster!=null && faster.next!=null){
            faster = faster.next.next;
            if (faster!=null && faster.next!=null) {
                slower = slower.next;
            }
        }
        slower.next=slower.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] items = {1,3,4,7,1,2,6};
        ListNode main = new ListNode(items[0]);
        ListNode dummy = main;
        for (int i = 1; i < items.length; i++) {
            dummy.next=new ListNode(items[i]);
            dummy=dummy.next;
        }
        ListNode listNode = deleteMiddle(main);
        while (Objects.nonNull(listNode)){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
}
