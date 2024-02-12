// https://leetcode.com/problems/house-robber/
// dp[k] = max amount of money you can rob ending at nums[k]
// dp[k] = max(dp[k - 2], dp[k - 3], ..., dp[0]) + nums[k]
// anwer = max(dp[k])
function rob(nums: number[]): number {
  if (nums.length === 1) {
    return nums[0];
  }

  const dp = Array(nums.length);
  dp[0] = nums[0];
  dp[1] = nums[1];
  let max = -Infinity;
  for (let i = 2; i < nums.length; i++) {
    max = Math.max(max, dp[i - 2]);
    dp[i] = max + nums[i];
  }

  return Math.max(...dp);
}
