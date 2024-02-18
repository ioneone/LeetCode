// https://leetcode.com/problems/last-stone-weight-ii/
function lastStoneWeightII(stones: number[]): number {
  const sum = stones.reduce((a, b) => a + b, 0)
  const capacity = Math.floor(sum / 2)
  const max = lastStoneWeightIIHelper(stones, capacity)
  return sum - max - max
}

function lastStoneWeightIIHelper(stones: number[], capacity: number): number {
  // dp[i][j]: the max we can achieve from stones[0...i] with capacity j
  const dp = [...Array(stones.length)].map((_) => [...Array(capacity + 1)])

  for (let j = 0; j < capacity + 1; j++) {
    dp[0][j] = stones[0] <= j ? stones[0] : 0
  }

  for (let i = 1; i < stones.length; i++) {
    for (let j = 0; j < capacity + 1; j++) {
      dp[i][j] = dp[i - 1][j] // skip stones[i]

      if (j - stones[i] >= 0) {
        // pick stones[i]
        dp[i][j] = Math.max(stones[i] + dp[i - 1][j - stones[i]], dp[i][j])
      }
    }
  }

  return dp[stones.length - 1][capacity]
}
