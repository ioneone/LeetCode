// https://leetcode.com/problems/maximum-length-of-repeated-subarray/
// dp[i][j]: max length of repeated subarray ending at nums1[i] and nums2[j]
// answer: max(dp[i][j])
// dp[i][j] = 0 or dp[i - 1][j - 1] + 1 if nums1[i] === nums2[j]
// dp[0][j] = 0 or 1 if nums1[0] === nums2[j]
// dp[i][0] = 0 or 1 if nums1[i] === nums2[0]
function findLength(nums1: number[], nums2: number[]): number {
  const dp = [...Array(nums1.length)].map((_) => [...Array(nums2.length)])

  for (let j = 0; j < nums2.length; j++) {
    dp[0][j] = nums1[0] === nums2[j] ? 1 : 0
  }

  for (let i = 1; i < nums1.length; i++) {
    dp[i][0] = nums1[i] === nums2[0] ? 1 : 0
    for (let j = 1; j < nums2.length; j++) {
      dp[i][j] = nums1[i] === nums2[j] ? dp[i - 1][j - 1] + 1 : 0
    }
  }

  return Math.max(...dp.flat())
}
