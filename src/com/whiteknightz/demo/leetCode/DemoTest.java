package com.whiteknightz.demo.leetCode;

import java.util.*;
import java.util.concurrent.CountDownLatch;

public class DemoTest {

    public static void q1(String input) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : input.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        System.out.println("Number of characters:" + map.size());
        List<Map.Entry<Character, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort((o1, o2) -> o1.getValue() - o2.getValue());

        System.out.println("Second most counted character is:" + entries.get(entries.size() - 2));


    }

    public static void q2(int[] input) {
        int[] clonedInput = input.clone();
        Arrays.sort(clonedInput);
        int secondLargest = clonedInput[clonedInput.length - 2];
        int requiredIndex = -1;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == secondLargest && input[i + 1] != input[i]) {
                requiredIndex = i;
                break;
            }
        }

        System.out.println("The index is:" + requiredIndex);
    }

    public static void q3() {
        for (int i = 0; i < 20; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < 19; j++) {
                builder.append(Math.max(9 - Math.min(Math.min(i, j), Math.min(20 - i - 1, 19 - j - 1)), 0));
            }
            System.out.println(builder.toString());
        }
    }

    static class Node {
        int value;
        Node next;

        Node(int x) {
            value = x;
            next = null;
        }
    }


    public static boolean q4(Node head) {
        if (head == null || head.next == null) {
            return false;
        }

        Node faster = head;
        Node slower = head;
        while (faster != null && faster.next != null) {
            faster = faster.next.next;
            slower = slower.next;
            if (faster == slower) {
                return true;
            }
        }
        return false;
    }

    public static class Foo {
        public void first() {
            System.out.println("first");
        }

        public void second() {
            System.out.println("second");
        }

        public void third() {
            System.out.println("third");
        }
    }

    public static void q5(){
        Foo foo = new Foo();
        CountDownLatch l1 = new CountDownLatch(1);
        CountDownLatch l2 = new CountDownLatch(1);
        Thread threadA = new Thread(()-> {
            foo.first();
            l1.countDown();
        });
        Thread threadB = new Thread(()-> {
            try {
                l1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            foo.second();
            l2.countDown();
        });
        Thread threadC = new Thread(()-> {
            try {
                l2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            foo.third();
        });

        threadB.start();
        threadC.start();
        threadA.start();
    }

//    In FIFO, the first element to get in will be the first to get out, eg: queue

    public static void q6(){
        Queue<Integer> queue = new LinkedList<>();
        int[] values = {1,2,3,4,5,6,7,8,9};
        for (int i :values) {
            queue.offer(i);
        }
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }

    public static int[] q7(int[] input){
        StringBuilder builder = new StringBuilder();
        int[] result = new int[input.length];
        int counter = 0;
        for (int j : input) {
            if (builder.indexOf(j+",") < 0) {
                result[counter] = j;
                counter++;
                builder.append(j).append(",");
            }
        }
//        String[] split = builder.toString().split(",");
        int[] finalVal = new int[counter];
        for (int i = 0; i < counter; i++) {
            finalVal[i]=result[i];
        }
        return finalVal;
    }


    public static void main(String[] args) {
        q1("aaabbcefgab");


        int[] q2 = {4, 5, 6, 6, 6, 7, 2};
        q2(q2);


        q3();


        Node head = new Node(3);
        Node node = new Node(2);
        head.next = node;
        head.next.next = new Node(0);
        head.next.next.next = new Node(-4);
        head.next.next.next.next = node;
        boolean result = q4(node);
        System.out.println("Result:" + result);


        q6();


        int[] q7 = {4, 5, 6, 9, 6, 7, 2, 13, 20, 11, 20};
        int[] resultQ7 = q7(q7);
        System.out.println("Result:");
        for (int i: resultQ7){
            System.out.println(i);
        }


        q5();
    }
}
