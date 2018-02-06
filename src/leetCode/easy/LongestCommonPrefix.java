package leetCode.easy;

import java.util.Objects;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {

    public static void main(String[] args){
        String[] strings = new String[10];
        strings[0] = "pr";
        strings[1] = "prefixToAStringIsWhat?";
        strings[2] = "prefiToAStringIsWhat?";
        strings[3] = "prefiToAStringIsWhat?";
        strings[4] = "prefiToAStringIsWhat?";
        strings[5] = "preToAStringIsWhat?";
        strings[6] = "pre_ToAStringIsWhat?";
        strings[7] = "preToAStringIsWhat?";
        strings[8] = "prefToAStringIsWhat?";
        strings[9] = "prefToAStringIsWhat?";

        System.out.println("Prefix: " + longestCommonPrefix(strings));
    }

    private static String longestCommonPrefix(String[] strs){
        String prefix = "";

        if (strs.length == 0){
            return prefix;
        }

        for (int i = 0; i < strs[0].length(); i++){
            char c = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++){
                if (i >= strs[j].length()){
                    return prefix;
                }
                if (!Objects.equals(strs[j].charAt(i), c)){
                    System.out.println("strs[" + j + "].charAt(" + i + ") = " + strs[j].charAt(i));
                    System.out.println("c = " + c);
                    return prefix;
                }
            }
            prefix += strs[0].charAt(i);
            System.out.println("prefix: " + prefix);
        }

        return prefix;
    }
}
