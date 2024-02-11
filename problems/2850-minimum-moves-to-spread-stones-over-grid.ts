// https://leetcode.com/problems/minimum-moves-to-spread-stones-over-grid/
// brute force
function minimumMoves(grid: number[][]): number {
  return minimumMovesHelper(grid, 0);
}

function minimumMovesHelper(grid: number[][], acc: number) {
  if (grid.every((row) => row.every((col) => col === 1))) {
    return acc;
  }

  let numMoves = Infinity;
  for (let i = 0; i < 3; i++) {
    for (let j = 0; j < 3; j++) {
      for (let k = 0; k < 3; k++) {
        for (let l = 0; l < 3; l++) {
          if (grid[i][j] === 0 && grid[k][l] > 1) {
            grid[i][j] = 1;
            grid[k][l] -= 1;
            const distance = Math.abs(i - k) + Math.abs(j - l);
            numMoves = Math.min(
              minimumMovesHelper(grid, acc + distance),
              numMoves
            );
            grid[i][j] = 0;
            grid[k][l] += 1;
          }
        }
      }
    }
  }

  return numMoves;
}
