package com.whiteknightz.demo.codewar;

public class SumOfDigits {
    public static int digital_root(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int sum = 0;
        for(char c: chars){
            sum+=Integer.parseInt(String.valueOf(c));
        }
        if (sum>9){
            sum=digital_root(sum);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Is what is expected for 16 is 7:"+digital_root(16));
        System.out.println("Is what is expected for 942 is 6:"+digital_root(942));
        System.out.println("Is what is expected for 132189 is 6:"+digital_root(132189));
        System.out.println("Is what is expected for 493193 is 2:"+digital_root(493193));
    }
}
