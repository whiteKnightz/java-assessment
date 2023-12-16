package com.whiteknightz.demo.leetCode.arrayAndString;

import java.util.Arrays;

/*
Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

 */
public class ReverseVowelsOfString {
    public static String reverseVowels(String s) {
        int len = s.length();
        int vowelsCnt = 0;
        boolean[] areVowels = new boolean[len];
//        List<String > vowels = new ArrayList<>(Arrays.asList("a", "e", "i", "o", "u"));
        for (int i = 0; i<len;i++){
            if(Arrays.asList("a", "e", "i", "o", "u").contains(s.substring(i, i + 1).toLowerCase())){
                areVowels[i]=true;
                vowelsCnt++;
            }
        }

        if (vowelsCnt>1){
            for (int i=0;i<len;i++){
                if (areVowels[i]){
                    for (int j=len-1;j>=0;j--){
                        if (areVowels[j] && i!=j){
                            s = exchangeChar(s, i, j);
                            areVowels[i]=false;
                            areVowels[j]=false;
                            vowelsCnt-=2;
                            break;
                        }
                    }
                }
                if(vowelsCnt<2){
                    break;
                }
            }
        }

        return s;
    }

    private static String exchangeChar(String s, int frontInd, int backInd) {
        return s.substring(0, frontInd) +
                s.charAt(backInd) +
                s.substring(frontInd + 1, backInd) + s.charAt(frontInd) +
                s.substring(backInd + 1);
    }

    public static void main(String[] args) {
        String s = "race car";
        String result = reverseVowels(s);

        System.out.println("Result:"+result);
    }
}
