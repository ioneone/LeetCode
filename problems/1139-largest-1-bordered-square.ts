// https://leetcode.com/problems/largest-1-bordered-square/
// dp1[i][j]: # of 1s at the top of grid[i][j] including grid[i][j]
// dp2[i][j]: # of 1s at the left of grid[i][j] including grid[i][j]
// dp3[i][j]: # of 1s at the down of grid[i][j] including grid[i][j]
// dp4[i][j]: # of 1s at the right of grid[i][j] including grid[i][j]
// dp1[i][j] = dp1[i - 1][j] + grid[i][j]
// dp2[i][j] = dp2[i][j - 1] + grid[i][j]
// dp3[i][j] = dp1[grid.length - 1][j] - dp1[i][j] + grid[i][j]
// dp4[i][j] = dp2[i][grid[0].length - 1] - dp2[i][j] + grid[i][j]
function largest1BorderedSquare(grid: number[][]): number {
  const dp1 = [...Array(grid.length)].map((_) => [...Array(grid[0].length)])
  const dp2 = [...Array(grid.length)].map((_) => [...Array(grid[0].length)])

  for (let i = 0; i < grid.length; i++) {
    for (let j = 0; j < grid[0].length; j++) {
      dp1[i][j] = grid[i][j]
      if (i - 1 >= 0) {
        dp1[i][j] += dp1[i - 1][j]
      }

      dp2[i][j] = grid[i][j]
      if (j - 1 >= 0) {
        dp2[i][j] += dp2[i][j - 1]
      }
    }
  }

  let answer = 0
  for (let i = 0; i < grid.length; i++) {
    for (let j = 0; j < grid[0].length; j++) {
      for (let k = 1; i + k <= grid.length && j + k <= grid[0].length; k++) {
        const top = i
        const left = j
        const right = j + k - 1
        const bottom = i + k - 1

        const numOnesLeft = dp1[bottom][left] - dp1[top][left] + grid[i][j]
        const numOnesTop = dp2[top][right] - dp2[top][left] + grid[i][j]
        const numOnesRight = dp1[bottom][right] - dp1[top][right] + grid[i][j]
        const numOnesBottom =
          dp2[bottom][right] - dp2[bottom][left] + grid[i][j]

        if (
          numOnesLeft === k &&
          numOnesTop === k &&
          numOnesRight === k &&
          numOnesBottom === k
        ) {
          answer = Math.max(answer, k * k)
        }
      }
    }
  }

  return answer
}
