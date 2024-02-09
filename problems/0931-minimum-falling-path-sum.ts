// https://leetcode.com/problems/minimum-falling-path-sum/
//
// dp[i][j] min falling path sum that ends at matrix[i][j]
// answer = min(dp[rows.length-1][*])
// dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i-1][j+1]) + matrix[i][j]
function minFallingPathSum(matrix: number[][]): number {
  const n = matrix.length;

  const dp = [...Array(n)].map((_) => [...Array(n)]);

  for (let j = 0; j < n; j++) {
    dp[0][j] = matrix[0][j];
  }

  for (let i = 1; i < n; i++) {
    for (let j = 0; j < n; j++) {
      let min = dp[i - 1][j];
      if (j - 1 >= 0) {
        min = Math.min(min, dp[i - 1][j - 1]);
      }
      if (j + 1 < n) {
        min = Math.min(min, dp[i - 1][j + 1]);
      }
      dp[i][j] = min + matrix[i][j];
    }
  }

  return Math.min(...dp[n - 1]);
}
