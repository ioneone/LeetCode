// https://leetcode.com/problems/maximum-sum-circular-subarray/
//
// dp1[i] = max subarray ending at nums[i]
// dp1[i] = max(nums[i], dp1[i - 1] + nums[i])
//
// dp2[i] = min subarray ending at nums[i]
// dp2[i] = min(nums[i], dp2[i + 1] + nums[i])
function maxSubarraySumCircular(nums: number[]): number {
  const dp1 = [...Array(nums.length)]
  const dp2 = [...Array(nums.length)]

  dp1[0] = nums[0]
  dp2[0] = nums[0]
  for (let i = 1; i < nums.length; i++) {
    dp1[i] = Math.max(nums[i], dp1[i - 1] + nums[i])
    dp2[i] = Math.min(nums[i], dp2[i - 1] + nums[i])
  }

  const sum = nums.reduce((a, b) => a + b, 0)

  return Math.max(
    Math.max(...dp1),
    sum === Math.min(...dp2) ? -Infinity : sum - Math.min(...dp2)
  )
}
