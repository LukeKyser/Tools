package leetCode.medium;

/**
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class IntegerToRoman {

    public static void main(String[] args){
        //int number = 3;

        for (int i = 1; i <= 100; i++){
            System.out.println(i + " = " + intToRoman(i));
        }
    }

    public static String intToRoman(int num){
        String roman = "";

        while (num >= 1000){
            num -= 1000;
            roman += "M";
        }

        if (num >= 900){
            num -= 900;
            roman += "CM";
        }

        if (num >= 500){
            num -= 500;
            roman += "D";
        }

        if (num >= 400){
            num -= 400;
            roman += "CD";
        }

        while (num >= 100){
            num -= 100;
            roman += "C";
        }

        if (num >= 90){
            num -= 90;
            roman += "XC";
        }

        if (num >= 50){
            num -= 50;
            roman += "L";
        }

        if (num >= 40){
            num -= 40;
            roman += "XL";
        }

        while (num >= 10){
            num -= 10;
            roman += "X";
        }

        if (num >= 9){
            num -= 9;
            roman += "IX";
        }

        if (num >= 5){
            num -= 5;
            roman += "V";
        }

        if (num >= 4){
            num -= 4;
            roman += "IV";
        }

        while (num >= 1){
            num -= 1;
            roman += "I";
        }
        return roman;
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
