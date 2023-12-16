package com.whiteknightz.demo.codewar;

public class DisemvowelTrolls {
    public static String disemvowel(String str) {
            return str.replaceAll("[aeiouAEIOU]","");
    }

    public static void main(String[] args) {
        String input = "This website is for losers LOL!";
        String expected = "Ths wbst s fr lsrs LL!";
        String result = disemvowel(input);
        System.out.println("Got expected result:"+result.equals(expected));
    }
}
