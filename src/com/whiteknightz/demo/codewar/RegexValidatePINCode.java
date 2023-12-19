package com.whiteknightz.demo.codewar;

import java.util.regex.Pattern;

/*
    ATM machines allow 4 or 6 digit PIN codes and PIN codes cannot contain anything but exactly 4 digits or exactly 6
    digits.

    If the function is passed a valid PIN string, return true, else return false.

    Examples (Input --> Output)
    "1234"   -->  true
    "12345"  -->  false
    "a234"   -->  false
 */
public class RegexValidatePINCode {
    public static boolean validatePin(String pin) {
        return pin.matches("[0-9]{4}|[0-9]{6}");
    }

    public static void main(String[] args) {
        System.out.println("'a234' must not match and is:"+validatePin("a234"));
        System.out.println("'.234' must not match and is:"+validatePin(".234"));
        System.out.println("'12345' must not match and is:"+validatePin("12345"));
        System.out.println("'123456' must match and is:"+validatePin("123456"));
        System.out.println("'1111' must match and is:"+validatePin("1111"));
    }
}
