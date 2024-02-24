// https://leetcode.com/problems/combination-sum-iv/
// dp[i]: # of combination sum for taget i
// answer = dp[target]
// dp[i] = sum(dp[i - nums[k]])
function combinationSum4(nums: number[], target: number): number {
  const dp = [...Array(target + 1)].fill(0)

  dp[0] = 1
  for (let i = 1; i <= target; i++) {
    for (let j = 0; j < nums.length; j++) {
      if (i - nums[j] >= 0) {
        dp[i] += dp[i - nums[j]]
      }
    }
  }

  return dp[target]
}
