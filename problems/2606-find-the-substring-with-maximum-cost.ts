// dp[k] = max cost substring ending at s[k]
// answer = max(dp[k])
// dp[k] = max(dp[k-1] + cost(s[k]), cost(s[k]))
function maximumCostSubstring(
  s: string,
  chars: string,
  vals: number[]
): number {
  const cost = {}
  for (let i = 97; i < 97 + 26; i++) {
    cost[String.fromCharCode(i)] = i - 96
  }
  for (let i = 0; i < chars.length; i++) {
    cost[chars[i]] = vals[i]
  }

  const dp = [...Array(s.length)]
  dp[0] = cost[s[0]]
  for (let i = 1; i < s.length; i++) {
    dp[i] = Math.max(dp[i - 1] + cost[s[i]], cost[s[i]])
  }

  return Math.max(...dp, 0)
}
