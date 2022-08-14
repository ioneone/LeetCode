package main.java;

public class LC0377 {
  // dp[i]: number of combinations that sum up to i
  // dp[i] = sum(dp[i - nums[j]]) for j=0...nums.length-1
  public int combinationSum4(int[] nums, int target) {
    return combinationSum4Helper(nums, target, 0);
  }

  public int combinationSum4Helper(int[] nums, int target, int current) {
    if (current == target) {
      return 1;
    }

    if (current > target) {
      return 0;
    }

    int ret = 0;
    for (int num : nums) {
      ret += combinationSum4Helper(nums, target, current + num);
    }
    return ret;
  }

  public static void main(String[] args) {
    LC0377 lc = new LC0377();
    System.out.println(lc.combinationSum4(new int[] {1, 2, 3}, 4)); // 7
    System.out.println(lc.combinationSum4(new int[] {1, 2, 3}, 32)); // 181997601
  }
}
