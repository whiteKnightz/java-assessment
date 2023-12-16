package com.whiteknightz.demo.leetCode.stack;

/*
    Given an encoded string, return its decoded string.

    The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated
    exactly k times. Note that k is guaranteed to be a positive integer.

    You may assume that the input string is always valid; there are no extra white spaces, square brackets are
    well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits
    are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

    The test cases are generated so that the length of the output will never exceed 105.
 */

import java.util.Stack;

public class DecodeString {
//    public static String decodeString(String s) {
//        StringBuilder builder = new StringBuilder();
//        int count = 0;
//        int pivot = -1;
//
//        Stack<Integer> countStack = new Stack<>();
//        Stack<StringBuilder> builderStack = new Stack<>();
//        StringBuilder currSubStr = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (Character.isDigit(c)){
//                if (count>0){
//                    count = count*10+Integer.parseInt(String.valueOf(c));
//                } else {
//                    count = Integer.parseInt(String.valueOf(c));
//                }
//            } else if (pivot>-1 && ((c>='0' && c<='9') || (c>='A' && c<='Z') || (c>='a' && c<='z'))){
//                currSubStr.append(c);
//            } else if(c=='['){
//                pivot = i;
//            } else if(c==']'){
//                builder.append(currSubStr.toString().repeat(Math.max(0, count)));
//                count = 0;
//                pivot = -1;
//                currSubStr.delete(0, currSubStr.length());
//            }
//        }
//        return builder.toString();
//    }

    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> resultStack = new Stack<>();

        int i = 0;
        StringBuilder currentString = new StringBuilder();

        while (i < s.length()) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                // Parse the number
                int count = 0;
                while (Character.isDigit(s.charAt(i))) {
                    count = count * 10 + (s.charAt(i) - '0');
                    i++;
                }
                countStack.push(count);
            } else if (ch == '[') {
                // Start a new nested string
                resultStack.push(currentString);
                currentString = new StringBuilder();
                i++;
            } else if (ch == ']') {
                // Combine the nested string with the count
                StringBuilder temp = currentString;
                currentString = resultStack.pop();
                int count = countStack.pop();
                for (int j = 0; j < count; j++) {
                    currentString.append(temp);
                }
                i++;
            } else {
                // Append characters to the current string
                currentString.append(ch);
                i++;
            }
        }

        return currentString.toString();
    }

    public static void main(String[] args) {
//        String s = "3[a]2[bc]";
        String s = "3[a2[c]]";
        String result = decodeString(s);
        System.out.println("Result:"+result);
    }
}
