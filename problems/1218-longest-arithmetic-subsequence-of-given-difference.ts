// https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/
//
// dp[k] = longest subsequence ending at arr[k]
// answer = max(dp[l])
// dp[k] = 1 + max(dp[l]) where arr[k] = arr[l] + difference
function longestSubsequence(arr: number[], difference: number): number {
  // longest subsequence ending at arr[k]
  const dp = [...Array(arr.length)]
  // keep track of max(dp[l]) where arr[k] = arr[l] + difference
  // key is (arr[l] + difference), value is max(dp[l])
  const maxMap = {}

  dp[0] = 1
  maxMap[arr[0] + difference] = dp[0]

  for (let k = 1; k < arr.length; k++) {
    dp[k] = 1 + (maxMap[arr[k]] ?? 0)
    maxMap[arr[k] + difference] = Math.max(
      maxMap[arr[k] + difference] ?? 0,
      dp[k]
    )
  }

  return Math.max(...dp)
}
