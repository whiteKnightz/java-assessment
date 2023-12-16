package com.whiteknightz.demo.leetCode.arrayAndString;

/*
Given an array of characters chars, compress it using the following algorithm:

Begin with an empty string s. For each group of consecutive repeating characters in chars:

If the group's length is 1, append the character to s.
Otherwise, append the character followed by the group's length.
The compressed string s should not be returned separately, but instead, be stored in the input character array chars.
Note that group lengths that are 10 or longer will be split into multiple characters in chars.

After you are done modifying the input array, return the new length of the array.

You must write an algorithm that uses only constant extra space.
 */
public class StringCompression {
//    public static int compress(char[] chars) {
//        int len = chars.length;
//        if (len==0 || len==1){
//            return len;
//        }
//
//        int index = 0;
//
//        for (int i = 0; i< len; i++){
//            char item = chars[i];
//            int count = 1;
//
//            while (i+1<len && chars[i]==chars[i+1]){
//                count++;
//                i++;
//            }
//            chars[index++] = item;
//
//            if (count>1){
//                char[] array = String.valueOf(count).toCharArray();
//                for (char val: array){
//                    chars[index++]=val;
//                }
//            }
//
//        }
//
//        return index;
//    }

    public static int compress(char[] chars) {
        int len = chars.length;
        if (len==0 || len==1){
            return len;
        }
        char lastChar = chars[0];
        int lastCharCount = 1;
        StringBuilder builder = new StringBuilder();
        builder.append(lastChar);

        for (int i = 1; i< len; i++){
            if (chars[i]==lastChar){
                lastCharCount+=1;
            } else {
                if (lastCharCount>1){
                    builder.append(lastCharCount);
                }
                builder.append(chars[i]);
                lastChar = chars[i];
                lastCharCount = 1;
            }
        }
        if (lastCharCount>1){
            builder.append(lastCharCount);
        }
        String s = builder.toString();
        for (int i =0;i<s.length();i++){
            chars[i]=s.charAt(i);
        }

        return s.length();
    }

    public static void main(String[] args) {
        char[] chars = {'a','b','c'};

        int result = compress(chars);

        System.out.println("Result:"+result);
    }
}
