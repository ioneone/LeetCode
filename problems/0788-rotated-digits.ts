// https://leetcode.com/problems/rotated-digits/
// dp[k] = rotated k or -1 if invalid
// answer = # of dp[k] where dp[k] !== k and dp[k] is valid
// dp[k] = dp[(k - k % 10) / 10] + dp[k % 10]
function rotatedDigits(n: number): number {
  const dp = [...Array(n + 1)]
  dp[0] = 0
  dp[1] = 1
  dp[2] = 5
  dp[3] = -1
  dp[4] = -1
  dp[5] = 2
  dp[6] = 9
  dp[7] = -1
  dp[8] = 8
  dp[9] = 6

  for (let i = 10; i <= n; i++) {
    const left = dp[(i - (i % 10)) / 10]
    const right = dp[i % 10]

    if (left === -1) {
      dp[i] = -1
    } else if (right === -1) {
      dp[i] = -1
    } else {
      dp[i] = left * 10 + right
    }
  }

  let answer = 0
  for (let i = 1; i <= n; i++) {
    if (dp[i] !== -1 && i !== dp[i]) {
      answer += 1
    }
  }

  return answer
}
