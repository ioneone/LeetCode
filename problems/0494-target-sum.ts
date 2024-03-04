// https://leetcode.com/problems/target-sum/
// dp[i][j]: # of ways for nums[0...i] to be j-1000
// answer = dp[nums.length-1][target+1000]
// dp[i][j] = dp[i-1][j-nums[i]] + dp[i-1][j+nums[i]]
function findTargetSumWays(nums: number[], target: number): number {
  const dp = [...Array(nums.length)].map((_) =>
    [...Array(1000 * 2 + 1)].fill(0)
  )

  // note if nums[0] === 0, then we set the dp value be 2
  dp[0][nums[0] + 1000] += 1
  dp[0][-nums[0] + 1000] += 1

  for (let i = 1; i < nums.length; i++) {
    for (let j = 0; j <= 2000; j++) {
      dp[i][j] = 0
      if (j - nums[i] >= 0) {
        // due to problem constraint,
        // these cases can be considered as 0
        // if j - nums[i] < 0, then sum < -1000
        // choose +nums[i]
        dp[i][j] += dp[i - 1][j - nums[i]]
      }

      if (j + nums[i] <= 2000) {
        // due to problem constraint,
        // these cases can be considered as 0
        // if j + nums[i] > 2000, then sum > 1000
        // choose -nums[i]
        dp[i][j] += dp[i - 1][j + nums[i]]
      }
    }
  }

  console.log(dp)

  return dp[nums.length - 1][target + 1000]
}
