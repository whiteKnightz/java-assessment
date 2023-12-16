package com.whiteknightz.demo.leetCode.linkedList;

/*
    Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with
    even indices, and return the reordered list.

    The first node is considered odd, and the second node is even, and so on.

    Note that the relative order inside both the even and odd groups should remain as it was in the input.

    You must solve the problem in O(1) extra space complexity and O(n) time complexity.
 */

import com.whiteknightz.demo.leetCode.ListNode;

import java.util.Objects;

public class OddEvenLinkedList {
    public static ListNode oddEvenList(ListNode head) {
        ListNode oddNode = new ListNode(0);
        ListNode evenNode = new ListNode(0);

        ListNode slower = oddNode;
        ListNode faster = evenNode;


        while (head!=null && head.next!=null){
            slower.next = head;
            slower=slower.next;
            faster.next = head.next;
            faster=faster.next;
            head=head.next.next;
        }
        if (head!=null){
            slower.next = head;
            slower = slower.next;
        }
        faster.next=null;

        slower.next = evenNode.next;
        return oddNode.next;
    }

    public static void main(String[] args) {
//        int[] items = {1,2,3,4,5};
        int[] items = {2,1,3,5,6,4,7};
        ListNode main = new ListNode(items[0]);
        ListNode dummy = main;
        for (int i = 1; i < items.length; i++) {
            dummy.next=new ListNode(items[i]);
            dummy=dummy.next;
        }
        ListNode listNode = oddEvenList(main);
        while (Objects.nonNull(listNode)){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
}
