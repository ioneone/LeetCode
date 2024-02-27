// https://leetcode.com/problems/count-submatrices-with-all-ones/
function numSubmat(mat: number[][]): number {
  const numRows = mat.length
  const numCols = mat[0].length
  let answer = 0

  for (let r1 = 0; r1 < numRows; r1++) {
    // h[k] === 1 means mat[r1...r2][k] === 1
    const h = [...Array(numCols)].fill(1)

    for (let r2 = r1; r2 < numRows; r2++) {
      for (let c = 0; c < numCols; c++) {
        h[c] = h[c] & mat[r2][c]
      }

      // length of consecutive 1s
      let length = 0
      for (let c = 0; c < numCols; c++) {
        length = h[c] === 0 ? 0 : length + 1
        answer += length
      }
    }
  }

  return answer
}
