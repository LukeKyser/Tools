package leetCode.easy;

import java.util.Objects;

/**
 * Given a string, find the first non-repeating character in it and return it's index.
 * If it doesn't exist, return -1.
 *
 * Examples:
 *      s = "leetcode"
 *      return 0.
 *      s = "loveleetcode"
 *      return 2.
 *
 * Note:
 *      You may assume the string contain only lowercase letters.
 */
public class FirstUniqueCharacterInAString {

    public static void main(String[] args){
        String str = "castlileintheDarknessc"; // Index of FNRC = 4

        System.out.println("fnrc: " + str.substring(1, str.length()));
        System.out.println("FNRC Index: " + firstUniqChar(str));
    }

    public static int firstUniqChar(String s) {
        int index = 0;
        int checkIndex;
        boolean uniqueFound = false;
        boolean match;

        while (index < s.length() && !uniqueFound){
            checkIndex = 0;
            match = false;

            while (checkIndex < s.length() && !match){
                if (index != checkIndex){
                    if (Objects.equals(s.charAt(index), s.charAt(checkIndex)))
                    {
                        match = true;
                    }
                    checkIndex++;
                } else {
                    checkIndex++;
                }
            }
            if (!match) {
                uniqueFound = true;
            }
            index++;
        }

        if (uniqueFound)
            return index - 1;
        else
            return -1;
    }
}
