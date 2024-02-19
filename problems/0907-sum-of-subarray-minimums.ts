// https://leetcode.com/problems/sum-of-subarray-minimums/
// dp[i] = sum of min subarrays ending at arr[i]
// answer = sum(dp[i])
// dp[i] = dp[k] + (i - k) * arr[i] where k is largest num s.t. k < i, arr[k] <= arr[i]
//   if the k doesn't exist, k = -1
//
// [3, 1, 2, 4, 3]
function sumSubarrayMins(arr: number[]): number {
  const mod = Math.pow(10, 9) + 7

  const dp = [...Array(arr.length)]
  dp[0] = arr[0]

  const indices = [0]

  for (let i = 1; i < arr.length; i++) {
    while (indices.length > 0 && arr[indices[indices.length - 1]] > arr[i]) {
      indices.pop()
    }

    if (indices.length > 0) {
      const k = indices[indices.length - 1]
      dp[i] = dp[k] + (((i - k) * arr[i]) % mod)
    } else {
      dp[i] = (i + 1) * arr[i]
    }

    dp[i] = dp[i] % mod

    // note every index poped, let's call it j,
    // satisifies arr[j] > arr[i]. so next time
    // we pop this i, we don't need to check j's.
    indices.push(i)
  }

  return dp.reduce((a, b) => (a + b) % mod, 0)
}
