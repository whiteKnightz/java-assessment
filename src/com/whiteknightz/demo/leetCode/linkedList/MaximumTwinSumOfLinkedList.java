package com.whiteknightz.demo.leetCode.linkedList;

import com.whiteknightz.demo.leetCode.ListNode;

import java.util.ArrayList;
import java.util.List;

/*
    In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of
    the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.

    For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only
    nodes with twins for n = 4.
    The twin sum is defined as the sum of a node and its twin.

    Given the head of a linked list with even length, return the maximum twin sum of the linked list.
 */
public class MaximumTwinSumOfLinkedList {

//    public static int pairSum(ListNode head) {
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode prev = null;
//        ListNode curr = dummy.next;
//        int len = 0;
//
//        while (curr.next!=null){
//            ListNode temp = curr.next;
//            curr.next=prev;
//            prev=curr;
//            curr=temp;
//            len++;
//        }
//
//        int maxVal = Integer.MIN_VALUE;
//        int i =0;
//        while (i*2<len){
//            maxVal = Math.max(maxVal, prev.val+head.val);
//            i++;
//            prev=prev.next;
//            head=head.next;
//        }
//
//        return maxVal;
//    }

    public static int pairSum(ListNode head) {
        List<Integer> values = new ArrayList<>();
        while (head!=null){
            values.add(head.val);
            head=head.next;
        }
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i*2 < values.size(); i++) {
            maxVal = Math.max(maxVal, values.get(i)+values.get(values.size()-i-1));
        }
        return maxVal;
    }


    public static void main(String[] args) {
        int[] items = {5,4,2,1};
        ListNode main = new ListNode(items[0]);
        ListNode dummy = main;
        for (int i = 1; i < items.length; i++) {
            dummy.next=new ListNode(items[i]);
            dummy=dummy.next;
        }
        int result = pairSum(main);
        System.out.println("Result:"+result);
    }
}
