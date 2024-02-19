// https://leetcode.com/problems/longest-mountain-in-array/
// dp1[k] = longest monotonically increasing array ending at arr[k]
// dp2[k] = longest monotonically decreasing array starting at arr[k]
// answer = max(dp1[k] + dp2[k] - 1) where dp1[k] >= 2 && dp2[k] >= 2
// dp1[k] = (arr[k-1] < arr[k]) ? (dp1[k-1] + 1) : 1
// dp2[k] = (arr[k] > arr[k+1]) ? (dp2[k+1] + 1) : 1
function longestMountain(arr: number[]): number {
  const dp1 = [...Array(arr.length)]
  const dp2 = [...Array(arr.length)]

  dp1[0] = 1
  for (let i = 1; i < arr.length; i++) {
    dp1[i] = arr[i - 1] < arr[i] ? dp1[i - 1] + 1 : 1
  }

  dp2[arr.length - 1] = 1
  for (let i = arr.length - 2; i >= 0; i--) {
    dp2[i] = arr[i] > arr[i + 1] ? dp2[i + 1] + 1 : 1
  }

  let answer = 0
  for (let i = 0; i < arr.length; i++) {
    if (dp1[i] >= 2 && dp2[i] >= 2) {
      answer = Math.max(answer, dp1[i] + dp2[i] - 1)
    }
  }

  return answer
}
