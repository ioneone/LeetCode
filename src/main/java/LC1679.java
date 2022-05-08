package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * You are given an integer array nums and an integer k.
 * 
 * In one operation, you can pick two numbers from the array whose sum equals k and remove them from
 * the array.
 * 
 * Return the maximum number of operations you can perform on the array.
 */
public class LC1679 {

  public static int maxOperations(int[] nums, int k) {
    List<Integer> arr = toList(nums);
    Collections.sort(arr);

    if (arr.size() < 2) {
      return 0;
    }

    int i = 0;
    int j = arr.size() - 1;
    int count = 0;

    while (i < j) {

      int sum = arr.get(i) + arr.get(j);

      if (sum > k) {
        j--;
      } else if (sum < k) {
        i++;
      } else {
        count++;
        i++;
        j--;
      }

    }

    return count;
  }

  private static List<Integer> toList(int[] nums) {
    List<Integer> ret = new ArrayList<>();
    for (int num : nums) {
      ret.add(num);
    }
    return ret;
  }

  public static void main(String[] args) {
    System.out.println(maxOperations(new int[] {1, 2, 3, 4}, 5)); // 2
    System.out.println(maxOperations(new int[] {3, 1, 3, 4, 3}, 6)); // 1
  }

}
