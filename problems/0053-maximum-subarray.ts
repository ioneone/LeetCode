// https://leetcode.com/problems/maximum-subarray/
//
// dp[k] = max sum array ending at nums[k]
// answer = max(dp[k])
// dp[k] = Math.max(dp[k - 1] + nums[k], nums[k])
function maxSubArray(nums: number[]): number {
  const dp = Array(nums.length);

  dp[0] = nums[0];
  for (let i = 1; i < nums.length; i++) {
    dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
  }

  return Math.max(...dp);
}
