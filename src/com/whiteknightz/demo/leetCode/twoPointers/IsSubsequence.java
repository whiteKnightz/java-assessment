package com.whiteknightz.demo.leetCode.twoPointers;

/*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the
characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of
"abcde" while "aec" is not).


 */

public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        if (s.length()==0){
            return true;
        } else if (s.length()==1){
            return t.contains(s);
        }
        int i = 0;
        int lastIndex = 0;
        while (i<s.length()){
            int ind = t.substring(lastIndex).indexOf(s.charAt(i));
            if (ind<0){
                return false;
            }
            i++;
            lastIndex += 1+ind;
        }
        return true;
    }

    public static void main(String[] args) {
//        String s = "b", t = "c";
//        String s = "acb", t = "ahbgdc";
//        String s = "axc", t = "ahbgdc";
        String s = "abc", t = "ahbgdc";
//        String s = "rjufvjafbxnbgriwgokdgqdqewn", t = "mjmqqjrmzkvhxlyruonekhhofpzzslupzojfuoztvzmmqvmlhgqxehojfowtrinbatjujaxekbcydldglkbxsqbbnrkhfdnpfbuaktupfftiljwpgglkjqunvithzlzpgikixqeuimmtbiskemplcvljqgvlzvnqxgedxqnznddkiujwhdefziydtquoudzxstpjjitmiimbjfgfjikkjycwgnpdxpeppsturjwkgnifinccvqzwlbmgpdaodzptyrjjkbqmgdrftfbwgimsmjpknuqtijrsnwvtytqqvookinzmkkkrkgwafohflvuedssukjgipgmypakhlckvizmqvycvbxhlljzejcaijqnfgobuhuiahtmxfzoplmmjfxtggwwxliplntkfuxjcnzcqsaagahbbneugiocexcfpszzomumfqpaiydssmihdoewahoswhlnpctjmkyufsvjlrflfiktndubnymenlmpyrhjxfdcq";

        boolean result = isSubsequence(s,t);

        System.out.println("Result:"+result);
    }
}
