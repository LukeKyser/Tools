package leetCode.medium;

import leetCode.lib.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked
 * list. You may assume the two numbers do not contain any leading zero,
 * except the number 0 itself.
 *
 * Example: Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *          Output: 7 -> 0 -> 8
 *          Explanation: 342 + 465 = 807
 */
public class AddTwoNumbers {

    private static ListNode listNode;

    public static void main(String[] args){
        int[] list1 = new int[3];
        list1[0] = 2;
        list1[1] = 4;
        list1[2] = 3;
        int[] list2 = new int[3];
        list2[0] = 5;
        list2[1] = 6;
        list2[2] = 4;
        loadList(list1, list2, 0);
    }

    private static void loadList(int[] l1, int[] l2, int i){
        listNode = new ListNode(2);
    }
}