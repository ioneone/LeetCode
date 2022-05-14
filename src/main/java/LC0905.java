package main.java;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an integer array nums, move all the even integers at the beginning of the array followed by
 * all the odd integers.
 * 
 * Return any array that satisfies this condition.
 */
public class LC905 {

  public static int[] sortArrayByParity(int[] nums) {

    int[] ret = new int[nums.length];

    Queue<Integer> oddNumberIndices = new LinkedList<>();

    for (int i = 0; i < nums.length; i++) {
      ret[i] = nums[i];

      if (ret[i] % 2 == 0) {
        if (!oddNumberIndices.isEmpty()) {
          int oddNumberIndex = oddNumberIndices.remove();
          int tmp = ret[oddNumberIndex];
          ret[oddNumberIndex] = ret[i];
          ret[i] = tmp;
          oddNumberIndices.add(i);
        }
      } else {
        oddNumberIndices.add(i);
      }
    }

    return ret;
  }

  public static void printIntArray(int[] nums) {
    System.out.print("(");
    for (int num : nums) {
      System.out.print(num + ",");
    }
    System.out.println(")");
  }

  public static void main(String[] args) {
    printIntArray(sortArrayByParity(new int[] {3, 1, 2, 4}));
    printIntArray(sortArrayByParity(new int[] {1, 0, 2}));
    printIntArray(sortArrayByParity(new int[] {0}));
  }

}
