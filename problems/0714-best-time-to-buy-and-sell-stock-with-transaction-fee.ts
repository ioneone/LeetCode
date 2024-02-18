// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
// dp1[i]: max profit selling at prices[i] for prices[0...i]
// dp2[i]: max profit buying at prices[i] for prices[0...i]
// answer = max(dp1[i])
// dp1[i] = max(dp2[j < i] - prices[j] + prices[i] - fee)
// dp2[i] = max(dp1[j < i], 0)
function maxProfit(prices: number[], fee: number): number {
  const dp1 = [...Array(prices.length)]
  const dp2 = [...Array(prices.length)]

  let answer = 0

  dp1[0] = undefined
  dp2[0] = 0

  if (prices.length === 1) {
    return answer
  }

  dp1[1] = dp2[0] + prices[1] - prices[0] - fee
  dp2[1] = 0
  answer = Math.max(answer, dp1[1])

  let maxDp1SoFar = dp1[1]
  let maxDp2MiscSoFar = Math.max(dp2[0] - prices[0], dp2[1] - prices[1])
  for (let i = 2; i < prices.length; i++) {
    dp1[i] = maxDp2MiscSoFar + prices[i] - fee
    dp2[i] = Math.max(maxDp1SoFar, 0)

    maxDp1SoFar = Math.max(maxDp1SoFar, dp1[i])
    maxDp2MiscSoFar = Math.max(maxDp2MiscSoFar, dp2[i] - prices[i])
    answer = Math.max(answer, dp1[i])
  }

  return answer
}
