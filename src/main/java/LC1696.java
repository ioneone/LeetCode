package main.java;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * You are given a 0-indexed integer array nums and an integer k.
 * 
 * You are initially standing at index 0. In one move, you can jump at most k steps forward without
 * going outside the boundaries of the array. That is, you can jump from index i to any index in the
 * range [i + 1, min(n - 1, i + k)] inclusive.
 * 
 * You want to reach the last index of the array (index n - 1). Your score is the sum of all nums[j]
 * for each index j you visited in the array.
 * 
 * Return the maximum score you can get.
 */
public class LC1696 {
  // constraint: k >= 1
  public int maxResult(int[] nums, int k) {
    // dp[i]: maximum score you can get from nums[0] to nums[i]
    // dp[i] = nums[i] + max(dp[i - j]) for j = 1...k
    int[] dp = new int[nums.length];
    dp[0] = nums[0];

    // keep track of max(dp[i - k]...dp[i - 1])
    PriorityQueue<Data> pq =
        new PriorityQueue<>((Data data1, Data data2) -> data2.value - data1.value);
    pq.add(new Data(0, dp[0]));

    for (int i = 1; i < nums.length; i++) {
      while (pq.peek().index < i - k) {
        pq.poll();
      }
      dp[i] = pq.peek().value + nums[i];
      pq.add(new Data(i, dp[i]));
    }

    return dp[nums.length - 1];
  }

  public static class Data {
    public Integer index;
    public Integer value;

    public Data(Integer index, Integer value) {
      this.index = index;
      this.value = value;
    }
  }

  public static void main(String[] args) {
    LC1696 lc = new LC1696();
    System.out.println(lc.maxResult(new int[] {1, -1, -2, 4, -7, 3}, 2)); // 7
    System.out.println(lc.maxResult(new int[] {10, -5, -2, 4, 0, 3}, 3)); // 17
    System.out.println(lc.maxResult(new int[] {1, -5, -20, 4, -1, 3, -6, -3}, 2)); // 0
  }
}
