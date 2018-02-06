package leetCode.easy;

import java.util.Objects;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class PalindromeNumber {

    public static void main(String[] args){
        int num = 123321;

        System.out.println("Number: " + num);
        System.out.println("isPalindrome: " + isPalindrome(num));
    }

    public static boolean isPalindrome(int x){
        String strInt = Integer.toString(x);
        String strIntRev = "";

        for (int i = strInt.length() - 1; i >= 0; i--) {
            strIntRev += strInt.charAt(i);
        }

        if (Objects.equals(strInt, strIntRev))
            return true;
        else
            return false;
    }
}
