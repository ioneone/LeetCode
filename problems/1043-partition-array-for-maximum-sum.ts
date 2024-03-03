// https://leetcode.com/problems/partition-array-for-maximum-sum/
// dp[i]: maxSumAfterPartitioning ending at arr[i]
// answer = dp[arr.length-1]
// dp[i] = max(dp[i-j] + max(arr[i-j+1], ..., arr[i]))
function maxSumAfterPartitioning(arr: number[], k: number): number {
  const dp = [...Array(arr.length)]

  dp[0] = arr[0]
  let maxSoFar = arr[0]
  for (let i = 1; i < k; i++) {
    maxSoFar = Math.max(maxSoFar, arr[i])
    dp[i] = maxSoFar * (i + 1)
  }

  for (let i = k; i < arr.length; i++) {
    dp[i] = dp[i - 1] + arr[i] * 1
    let maxSoFar = arr[i]
    for (let j = 1; j < k; j++) {
      maxSoFar = Math.max(maxSoFar, arr[i - j])
      dp[i] = Math.max(dp[i], dp[i - 1 - j] + maxSoFar * (j + 1))
    }
  }

  return dp[arr.length - 1]
}
