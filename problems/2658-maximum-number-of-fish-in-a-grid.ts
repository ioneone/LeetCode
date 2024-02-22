// https://leetcode.com/problems/maximum-number-of-fish-in-a-grid/
function findMaxFish(grid: number[][]): number {
  const rows = grid.length
  const cols = grid[0].length
  const visited = [...Array(rows)].map((_) => [...Array(cols)])

  let answer = 0
  for (let r = 0; r < rows; r++) {
    for (let c = 0; c < cols; c++) {
      if (grid[r][c] > 0) {
        answer = Math.max(answer, dfs(grid, r, c, visited))
      }
    }
  }

  return answer
}

function dfs(
  grid: number[][],
  r: number,
  c: number,
  visited: boolean[][]
): number {
  if (r < 0 || r >= grid.length) {
    return 0
  }

  if (c < 0 || c >= grid[0].length) {
    return 0
  }

  if (visited[r][c]) {
    return 0
  }

  if (grid[r][c] === 0) {
    return 0
  }

  let acc = grid[r][c]
  visited[r][c] = true

  acc += dfs(grid, r - 1, c, visited)
  acc += dfs(grid, r, c - 1, visited)
  acc += dfs(grid, r + 1, c, visited)
  acc += dfs(grid, r, c + 1, visited)

  return acc
}
