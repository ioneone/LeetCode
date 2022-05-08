package main.java;

/**
 * Given an integer array nums, you need to find one continuous subarray that if you only sort this
 * subarray in ascending order, then the whole array will be sorted in ascending order.
 * 
 * Return the shortest such subarray and output its length.
 */
public class LC581 {

  public static int findUnsortedSubarray(int[] nums) {

    if (nums.length == 0) {
      return 0;
    }

    int[] dpMin = new int[nums.length]; // dpMin[i] = min(nums[i], nums[i + 1], ..., nums[n - 1])
    int[] dpMax = new int[nums.length]; // dpMax[i] = max(nums[0], nums[1], ..., nums[i])

    dpMin[nums.length - 1] = nums[nums.length - 1];
    dpMax[0] = nums[0];

    for (int i = nums.length - 2; i >= 0; i--) {
      dpMin[i] = Math.min(dpMin[i + 1], nums[i]);
    }

    for (int i = 1; i < nums.length; i++) {
      dpMax[i] = Math.max(dpMax[i - 1], nums[i]);
    }

    int i = 0;
    int j = nums.length - 1;

    while (i < nums.length - 1 && dpMin[i] == nums[i]) {
      i++;
    }

    while (j > 0 && dpMax[j] == nums[j]) {
      j--;
    }

    if (i >= j) {
      return 0;
    }

    return j - i + 1;

  }

  public static void main(String[] args) {
    System.out.println(findUnsortedSubarray(new int[] {2, 6, 4, 8, 10, 9, 15})); // 5
    System.out.println(findUnsortedSubarray(new int[] {1, 2, 3, 4})); // 0
    System.out.println(findUnsortedSubarray(new int[] {1})); // 0
  }
}
