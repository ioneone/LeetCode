// https://leetcode.com/problems/minimum-path-sum/
// dp[i][j]: min path sum from grid[0][0] to grid[i][j]
// answer = dp[m-1][n-1]
// dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
function minPathSum(grid: number[][]): number {
  const m = grid.length
  const n = grid[0].length

  const dp = [...Array(m)].map((_) => [...Array(n)])
  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      let prev = Infinity
      if (i - 1 >= 0) {
        prev = Math.min(prev, dp[i - 1][j])
      }
      if (j - 1 >= 0) {
        prev = Math.min(prev, dp[i][j - 1])
      }
      if (prev === Infinity) {
        prev = 0
      }

      dp[i][j] = prev + grid[i][j]
    }
  }

  return dp[m - 1][n - 1]
}
