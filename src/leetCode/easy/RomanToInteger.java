package leetCode.easy;

/**
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class RomanToInteger {

    public static void main(String[] args){
        //String roman = "LXXXVIII";
        String roman = "MMCDXLIX";

        System.out.println(roman + " = " + romanToInt(roman));
    }

    public static int romanToInt(String s){
        int retInt = 0;

        for (int i = s.length() - 1; i >= 0; i--){
            if (i != 0) {
                int current = charValue(s.charAt(i));
                int prev = charValue(s.charAt(i - 1));

                if (current > prev) {
                    retInt += current - prev;
                    i--;
                } else {
                    retInt += current;
                }
            } else {
                retInt += charValue(s.charAt(i));
            }
        }
        return retInt;
    }

    public static int charValue(char c){
        if (c == 'I')
            return 1;
        if (c == 'V')
            return 5;
        if (c == 'X')
            return 10;
        if (c == 'L')
            return 50;
        if (c == 'C')
            return 100;
        if (c == 'D')
            return 500;
        if (c == 'M')
            return 1000;

        return 0;
    }
}
