// https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/
// dp1[k]: max subarray sum ending at arr[k]
// dp2[k]: max subarray sum starting at arr[k]
// answer = max(dp1[k], dp1[k-1]+dp[k+1])
function maximumSum(arr: number[]): number {
  const dp1 = [...Array(arr.length)]
  const dp2 = [...Array(arr.length)]

  dp1[0] = arr[0]
  for (let i = 1; i < arr.length; i++) {
    dp1[i] = Math.max(dp1[i - 1] + arr[i], arr[i])
  }
  dp2[arr.length - 1] = arr[arr.length - 1]
  for (let i = arr.length - 2; i >= 0; i--) {
    dp2[i] = Math.max(arr[i] + dp2[i + 1], arr[i])
  }

  let answer = Math.max(...dp1)
  for (let i = 1; i < arr.length - 1; i++) {
    answer = Math.max(answer, dp1[i - 1] + dp2[i + 1])
  }

  return answer
}
