package com.whiteknightz.demo.leetCode.linkedList;

/*
    Given the head of a singly linked list, reverse the list, and return the reversed list.
 */

import com.whiteknightz.demo.leetCode.ListNode;

import java.util.Objects;

public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr!=null){
            ListNode temp = curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }

        return prev;
    }

    public static void main(String[] args) {
        int[] items = {1,2,3,4,5};
        ListNode main = new ListNode(items[0]);
        ListNode dummy = main;
        for (int i = 1; i < items.length; i++) {
            dummy.next=new ListNode(items[i]);
            dummy=dummy.next;
        }
        ListNode listNode = reverseList(main);
        while (Objects.nonNull(listNode)){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
}
