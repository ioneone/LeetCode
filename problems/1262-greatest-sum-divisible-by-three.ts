// https://leetcode.com/problems/greatest-sum-divisible-by-three/
// dp[i][j] = max possible sum for nums[0...i] where sum % 3 is j
// answer = dp[nums.length-1][0]
// dp[i][0] = dp[i - 1][(3 - nums[i] % 3) % 3] + nums[i]
// dp[i][1] = dp[i - 1][(4 - nums[i] % 3) % 3] + nums[i]
// dp[i][2] = dp[i - 1][(5 - nums[i] % 3) % 3] + nums[i]
function maxSumDivThree(nums: number[]): number {
  const dp = [...Array(nums.length)].map((_) => [...Array(3)])

  dp[0][0] = nums[0] % 3 === 0 ? nums[0] : undefined
  dp[0][1] = nums[0] % 3 === 1 ? nums[0] : undefined
  dp[0][2] = nums[0] % 3 === 2 ? nums[0] : undefined

  for (let i = 1; i < nums.length; i++) {
    for (let j = 0; j < 3; j++) {
      dp[i][j] = dp[i - 1][j]

      if (nums[i] % 3 === j) {
        dp[i][j] = Math.max(dp[i][j] ?? -Infinity, nums[i])
      }

      // prev max that complements current remainder
      const prev = dp[i - 1][(j + 3 - (nums[i] % 3)) % 3]
      if (prev != null) {
        dp[i][j] = Math.max(dp[i][j] ?? -Infinity, prev + nums[i])
      }
    }
  }

  return dp[nums.length - 1][0] ?? 0
}
