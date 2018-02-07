package leetCode.easy;

import java.util.Objects;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid. The brackets must close in the correct
 * order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParenthesis {
    public static void main(String[] args){
        String str = "}(";

        System.out.println("Is " + str + " valid?: " + isValid(str));
    }

    private static boolean isValid(String s) {

        if (s.length() <= 1){
            return false;
        }

        for (int i = 0; i < s.length(); i++){
            if (!Objects.equals(s.charAt(i), '(')
                    && !Objects.equals(s.charAt(i), ')')
                    && !Objects.equals(s.charAt(i), '{')
                    && !Objects.equals(s.charAt(i), '}')
                    && !Objects.equals(s.charAt(i), '[')
                    && !Objects.equals(s.charAt(i), ']')){
                return false;
            }
            if (i != s.length() - 1){
                if (Objects.equals(s.charAt(i), '(') && !Objects.equals(s.charAt(i + 1), ')')){
                    return false;
                }
                if (Objects.equals(s.charAt(i), '{') && !Objects.equals(s.charAt(i + 1), '}')){
                    return false;
                }
                if (Objects.equals(s.charAt(i), '[') && !Objects.equals(s.charAt(i + 1), ']')){
                    return false;
                }
            } else {
                if (Objects.equals(s.charAt(i), '(')){
                    return false;
                }
                if (Objects.equals(s.charAt(i), '{')){
                    return false;
                }
                if (Objects.equals(s.charAt(i), '[')){
                    return false;
                }
            }
            if (i != 0){
                if (Objects.equals(s.charAt(i), ')') && !Objects.equals(s.charAt(i - 1), '(')){
                    return false;
                }
                if (Objects.equals(s.charAt(i), '}') && !Objects.equals(s.charAt(i - 1), '{')){
                    return false;
                }
                if (Objects.equals(s.charAt(i), ']') && !Objects.equals(s.charAt(i - 1), '[')){
                    return false;
                }
            } else {
                if (Objects.equals(s.charAt(i), ')')){
                    return false;
                }
                if (Objects.equals(s.charAt(i), '}')){
                    return false;
                }
                if (Objects.equals(s.charAt(i), ']')){
                    return false;
                }
            }
        }

        return true;
    }
}
