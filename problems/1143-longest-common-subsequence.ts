// dp[i][j]: longest common subsequence of text1[0...i] and text2[0...j]
// answer = dp[text1.length-1][text2.length-1]
// dp[i][j] = max(dp[i-1][j-1]+1 if text1[i] === text2[j], dp[i-1][j], dp[i][j-1])
function longestCommonSubsequence(text1: string, text2: string): number {
  const dp = [...Array(text1.length)].map((_) => [...Array(text2.length)])

  dp[0][0] = text1[0] === text2[0] ? 1 : 0
  for (let j = 1; j < text2.length; j++) {
    dp[0][j] = Math.max(dp[0][j - 1], text1[0] === text2[j] ? 1 : 0)
  }

  for (let i = 1; i < text1.length; i++) {
    dp[i][0] = Math.max(dp[i - 1][0], text1[i] === text2[0] ? 1 : 0)
    for (let j = 1; j < text2.length; j++) {
      dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1])
      if (text1[i] === text2[j]) {
        dp[i][j] = Math.max(dp[i][j], 1 + dp[i - 1][j - 1])
      }
    }
  }

  return dp[text1.length - 1][text2.length - 1]
}
