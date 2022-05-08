package main.java;

import java.util.Stack;

/**
 * Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i],
 * nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].
 * 
 * Return true if there is a 132 pattern in nums, otherwise, return false.
 */
public class LC456 {

  public static boolean find132pattern(int[] nums) {

    Stack<Integer> bottoms = new Stack<>();

    bottoms.add(nums[nums.length - 1]);

    Integer a3 = null;

    for (int i = nums.length - 2; i >= 0; i--) {

      if (a3 != null && nums[i] < a3) {
        return true;
      }

      if (!bottoms.isEmpty() && nums[i] > bottoms.peek()) {
        // found top, figure out bottom
        while (!bottoms.isEmpty() && nums[i] > bottoms.peek()) {
          a3 = bottoms.pop();
        }
      }

      bottoms.add(nums[i]);
    }

    return false;
  }

  public static void main(String[] args) {
    System.out.println(find132pattern(new int[] {1, 2, 3, 4})); // false
    System.out.println(find132pattern(new int[] {3, 1, 4, 2})); // true
    System.out.println(find132pattern(new int[] {-1, 3, 2, 0})); // true
    System.out.println(find132pattern(new int[] {1, 0, 1, -4, -3})); // false
    System.out.println(find132pattern(new int[] {1, 2, 3, 3, 3, 4, 5, 3})); // true
    System.out.println(find132pattern(new int[] {3, 5, 0, 3, 4})); // true
  }
}
