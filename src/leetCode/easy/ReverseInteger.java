package leetCode.easy;

import java.util.Objects;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1: Input: 123
 *            Output: 321
 * Example 2: Input: -123
 *            Output: -321
 * Example 3: Input: 120
 *            Output: 21
 *
 * Note: Assume we are dealing with an environment which could
 *      only hold integers within the 32-bit signed integer range.
 *      For the purpose of this problem, assume that your function
 *      returns 0 when the reversed integer overflows.
 */
public class ReverseInteger {

    public static void main(String[] args){
        int number = reverse(-964631);
        System.out.println("Integer Reversed: " + number);
    }

    public static int reverse(int x){
        try {
            String strInt;
            String newStrInt = "";

            if (x < 0)
                strInt = Integer.toString(x * -1);
            else
                strInt = Integer.toString(x);

            for (int i = strInt.length() - 1; i >= 0; i--) {
                if (!Objects.equals(strInt.charAt(i), "0"))
                    newStrInt += strInt.charAt(i);
            }

            if (x < 0)
                return Integer.parseInt(newStrInt) * -1;
            else
                return Integer.parseInt(newStrInt);
        }
        catch(NumberFormatException e){return 0;}
    }
}
