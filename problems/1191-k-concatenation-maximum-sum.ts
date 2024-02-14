// https://leetcode.com/problems/k-concatenation-maximum-sum/

// dp[k] = max sub array of ending at arr[k]
// dp1[k] = sum of arr[0...k]
// dp2[k] = sum of arr[k...arr.length-1]
// sum of arr[i...j] = dp1[j] + dp2[i] - sum
// sum of arr2[i...j]
// = (j < arr.length ? dp1[j] : sum + dp1[j - arr.length]) +
//   (i < arr.length ? dp2[i] + sum : dp2[i - arr.length]) -
//   sum * 2
function kConcatenationMaxSum(arr: number[], k: number): number {
  const mod = Math.pow(10, 9) + 7

  if (k === 0) {
    return 0
  }

  const dp = Array(arr.length)
  const dp1 = Array(arr.length)
  const dp2 = Array(arr.length)

  const sum = arr.reduce((a, b) => a + b, 0)

  dp1[0] = arr[0]
  for (let i = 1; i < arr.length; i++) {
    dp1[i] = dp1[i - 1] + arr[i]
  }

  dp2[arr.length - 1] = arr[arr.length - 1]
  for (let i = arr.length - 2; i >= 0; i--) {
    dp2[i] = arr[i] + dp2[i + 1]
  }

  dp[0] = arr[0]
  for (let i = 1; i < arr.length; i++) {
    dp[i] = Math.max(dp[i - 1] + arr[i], arr[i])
  }

  // max of sub array with single array
  let oneArrayMax = 0
  for (let i = 0; i < arr.length; i++) {
    oneArrayMax = Math.max(oneArrayMax, dp[i])
  }

  if (k === 1) {
    return oneArrayMax % mod
  }

  const maxPrefixSum = Math.max(...dp1)
  const maxSuffixSum = Math.max(...dp2)

  return (
    Math.max(
      oneArrayMax,
      sum * k,
      maxSuffixSum + Math.max(0, sum * (k - 2)) + maxPrefixSum
    ) % mod
  )
}
