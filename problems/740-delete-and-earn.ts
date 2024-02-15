// https://leetcode.com/problems/delete-and-earn/
// arr[k]: { num: number, count: number }
// dp[k]: max you can earn ending at arr[k] (picking arr[k].num)
// answer = max(dp[k])
// dp[k] = arr[k].num * arr[k].count + max(dp[k - 1], dp[k - 2], ...)
//   * dp[k - 1] is included only if arr[k - 1].num < arr[k].num - 1
function deleteAndEarn(nums: number[]): number {
  const numMap = {}
  for (let i = 0; i < nums.length; i++) {
    if (numMap[nums[i]]) {
      numMap[nums[i]] = numMap[nums[i]] + 1
    } else {
      numMap[nums[i]] = 1
    }
  }
  const keys = Object.keys(numMap).sort((a, b) => Number(a) - Number(b))

  const arr = []
  for (let i = 0; i < keys.length; i++) {
    arr.push({ num: Number(keys[i]), count: numMap[keys[i]] })
  }

  if (arr.length === 1) {
    return arr[0].num * arr[0].count
  }

  const dp = [...Array(arr.length)]
  dp[0] = arr[0].num * arr[0].count
  dp[1] = arr[1].num * arr[1].count + (arr[0].num < arr[1].num - 1 ? dp[0] : 0)
  let maxSoFar = Math.max(dp[0], dp[1])
  let maxSoFarWithoutPrev = dp[0]
  for (let i = 2; i < arr.length; i++) {
    dp[i] = arr[i].num * arr[i].count
    if (arr[i - 1].num < arr[i].num - 1) {
      dp[i] += maxSoFar
    } else {
      dp[i] += maxSoFarWithoutPrev
    }
    maxSoFar = Math.max(maxSoFar, dp[i])
    maxSoFarWithoutPrev = Math.max(maxSoFarWithoutPrev, dp[i - 1])
  }

  return Math.max(...dp)
}
