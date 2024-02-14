// https://leetcode.com/problems/as-far-from-land-as-possible/
// dp[i][j]: distance to nearest land
// answer = max(dp[i][j])
// 1st pass: dp[i][j] = 1 + Math.min(dp[i][j - 1], dp[i - 1][j])
// 2nd pass: dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j + 1])
function maxDistance(grid: number[][]): number {
  const n = grid.length

  const dp = [...Array(n)].map((_) => [...Array(n)].fill(Infinity))

  // 1st pass: top-left
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      dp[i][j] = grid[i][j] === 1 ? 0 : dp[i][j]
      if (j - 1 >= 0) {
        dp[i][j] = Math.min(1 + dp[i][j - 1], dp[i][j])
      }
      if (i - 1 >= 0) {
        dp[i][j] = Math.min(1 + dp[i - 1][j], dp[i][j])
      }
    }
  }

  // 2nd pass: bottom-right
  for (let i = n - 1; i >= 0; i--) {
    for (let j = n - 1; j >= 0; j--) {
      // already done in 1st pass
      // dp[i][j] = grid[i][j] === 1 ? 0 : dp[i][j]
      if (i + 1 < n) {
        dp[i][j] = Math.min(1 + dp[i + 1][j], dp[i][j])
      }
      if (j + 1 < n) {
        dp[i][j] = Math.min(1 + dp[i][j + 1], dp[i][j])
      }
    }
  }

  let ret = -1
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      if (grid[i][j] === 0 && dp[i][j] !== Infinity) {
        ret = Math.max(ret, dp[i][j])
      }
    }
  }

  return ret
}
