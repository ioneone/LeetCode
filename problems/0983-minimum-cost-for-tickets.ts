// https://leetcode.com/problems/minimum-cost-for-tickets/
// dp[k]: min cost at day k
// answer = dp[365]
// dp[k] = dp[k - 1] if not travel day
//       or min(dp[k - 1] + costs[0], dp[k - 7] + costs[1], dp[k - 30]) + costs[2]) if travel day
function mincostTickets(days: number[], costs: number[]): number {
  const dp = [...Array(366)]

  const travelDayMap = {}
  for (let i = 0; i < days.length; i++) {
    travelDayMap[days[i]] = true
  }

  dp[0] = 0
  for (let i = 1; i <= 365; i++) {
    if (travelDayMap[i]) {
      dp[i] = dp[i - 1] + costs[0]
      dp[i] = Math.min(dp[i], dp[Math.max(i - 7, 0)] + costs[1])
      dp[i] = Math.min(dp[i], dp[Math.max(i - 30, 0)] + costs[2])
    } else {
      dp[i] = dp[i - 1]
    }
  }

  return dp[365]
}
