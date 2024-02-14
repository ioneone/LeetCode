// https://leetcode.com/problems/minimize-maximum-of-array/
// [3,7,1] -> [4,6,1] -> [5,5,1] sum is 11, avg is 3.6666
// case 1: avg is bigger than prev answer
// [3,7,1,100] -> [5,5,1,100] sum is 111, avg is 25.25
// case 2: avg is not bigger than prev answer
// [3,7,1,4] -> [5,5,1,4] sum is 15, avg is 3.75
// [3,7,1,6] -> [5,5,1,6]  sum is 17, avg is 4.25
// dp[k] = minimizeArrayValue for nums[0...k]
// dp[k] = max(dp[k-1],  ceil(sum(nums[0...k])/k+1))
function minimizeArrayValue(nums: number[]): number {
  const sum = Array(nums.length)
  const dp = Array(nums.length)
  sum[0] = nums[0]
  dp[0] = nums[0]
  for (let i = 1; i < nums.length; i++) {
    sum[i] = sum[i - 1] + nums[i]
    dp[i] = Math.max(dp[i - 1], Math.ceil(sum[i] / (i + 1)))
  }

  return dp[nums.length - 1]
}
