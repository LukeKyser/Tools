package leetCode.easy;

import java.util.Random;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
public class TwoSum {
    // Constants
    private static final int ARRAY_SIZE = 6;

    public static void main(String[] args){
        int[] numArray  = new int[ARRAY_SIZE];
        Random rand = new Random();
        int arrayValue;
        int targetSum;

        // Create int array with random values
        for (int i = 0; i < ARRAY_SIZE; i++){
            arrayValue = rand.nextInt() % 9;
            if(arrayValue < 0)
                arrayValue *= -1;
            numArray[i] = arrayValue;
        }

        // Create target int with random value
        targetSum = rand.nextInt() % 10;
        if (targetSum < 0)
            targetSum *= -1;

        // Run twoSum method and print
        int[] result = twoSum(numArray, targetSum);
        System.out.println("Result: " + result[0] + ", " + result[1]);
        System.out.println("Target: " + targetSum);

        // Print array
        for (int i = 0; i < ARRAY_SIZE; i++){
            System.out.println("test[" + i + "]: " + numArray[i]);
        }
    }

    /**
     * Returns indices of the two numbers such that they add up to a specific target.
     * @param nums
     * @param target
     * @return ret
     */
    private static int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        ret[0] = -1;
        ret[1] = -1;

        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    ret[0] = i;
                    ret[1] = j;
                    return ret;
                }
            }
        }

        return ret;
    }
}
