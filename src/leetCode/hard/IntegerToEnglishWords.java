package leetCode.hard;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
 * For example,
 *      123 -> "One Hundred Twenty Three"
 *      12345 -> "Twelve Thousand Three Hundred Forty Five"
 *      1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 */
public class IntegerToEnglishWords {

    public static void main(String[] args){
        int number = 1000000003;
        System.out.println(number + " -> " + numberToWords(number));
    }

    private static String numberToWords(int num){
        String strNum = Integer.toString(num);
        if (Objects.equals(strNum, "0"))
            return "Zero";
        String strWord = "";

        ArrayList<String> hundreds = hundredsStrings(strNum);
        ArrayList<String> bigNumberStrings = new ArrayList<>();
        bigNumberStrings.add("");
        bigNumberStrings.add(" Thousand");
        bigNumberStrings.add(" Million");
        bigNumberStrings.add(" Billion");

        for (int i = hundreds.size() - 1; i >= 0; i--){
            if (!Objects.equals(hundreds.get(i), "")){
                strWord += hundreds.get(i) + bigNumberStrings.get(i);
            }
        }

        return strWord.substring(1, strWord.length());
    }

    private static ArrayList<String> hundredsStrings(String strNum){
        ArrayList<String> hundreds = new ArrayList<>();
        String strTemp = "";
        String strWord = "";

        while (strNum.length() > 0){
            if (strNum.length() >= 3){
                strTemp = strNum.substring(strNum.length() - 3, strNum.length());
                strNum = strNum.substring(0, strNum.length() - 3);

                if (!Objects.equals(strTemp.charAt(0), '0')){
                    strWord += onesString(strTemp.charAt(0)) + " Hundred";
                }

                if (Objects.equals(strTemp.charAt(1), '1') && !Objects.equals(strTemp.charAt(2), '0')){
                    strWord += teensString(strTemp.charAt(2));
                } else {
                    strWord += tensString(strTemp.charAt(1));
                    strWord += onesString(strTemp.charAt(2));
                }
            } else {
                strTemp = strNum;
                if (strNum.length() == 2){
                    if (Objects.equals(strTemp.charAt(0), '1') && !Objects.equals(strTemp.charAt(1), '0')){
                        strWord += teensString(strTemp.charAt(1));
                    } else {
                        strWord += tensString(strTemp.charAt(0));
                        strWord += onesString(strTemp.charAt(1));
                    }
                } else {
                    strWord += onesString(strTemp.charAt(0));
                }

                strNum = "";
            }

            hundreds.add(strWord);
            strWord = "";
        }

        return hundreds;
    }

    private static String tensString(char num){
        if (Objects.equals(num, '1'))
            return " Ten";
        if (Objects.equals(num, '2'))
            return " Twenty";
        if (Objects.equals(num, '3'))
            return " Thirty";
        if (Objects.equals(num, '4'))
            return " Forty";
        if (Objects.equals(num, '5'))
            return " Fifty";
        if (Objects.equals(num, '6'))
            return " Sixty";
        if (Objects.equals(num, '7'))
            return " Seventy";
        if (Objects.equals(num, '8'))
            return " Eighty";
        if (Objects.equals(num, '9'))
            return " Ninety";
        return "";
    }

    private static String teensString(char num){
        if (Objects.equals(num, '1'))
            return " Eleven";
        if (Objects.equals(num, '2'))
            return " Twelve";
        if (Objects.equals(num, '3'))
            return " Thirteen";
        if (Objects.equals(num, '4'))
            return " Fourteen";
        if (Objects.equals(num, '5'))
            return " Fifteen";
        if (Objects.equals(num, '6'))
            return " Sixteen";
        if (Objects.equals(num, '7'))
            return " Seventeen";
        if (Objects.equals(num, '8'))
            return " Eighteen";
        if (Objects.equals(num, '9'))
            return " Nineteen";
        return "";
    }

    private static String onesString(char num){
        if (Objects.equals(num, '1'))
            return " One";
        if (Objects.equals(num, '2'))
            return " Two";
        if (Objects.equals(num, '3'))
            return " Three";
        if (Objects.equals(num, '4'))
            return " Four";
        if (Objects.equals(num, '5'))
            return " Five";
        if (Objects.equals(num, '6'))
            return " Six";
        if (Objects.equals(num, '7'))
            return " Seven";
        if (Objects.equals(num, '8'))
            return " Eight";
        if (Objects.equals(num, '9'))
            return " Nine";
        return "";
    }
}
