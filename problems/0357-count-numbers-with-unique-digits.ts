// https://leetcode.com/problems/count-numbers-with-unique-digits/
//
// dp[k] = countNumbersWithUniqueDigits(k)
function countNumbersWithUniqueDigits(n: number): number {
  if (n === 0) {
    return 1
  }

  let dpF = [...Array(n + 1)]
  let dp = [...Array(n + 1)]
  dp[0] = 1

  for (let i = 1; i <= n; i++) {
    dp[i] = (9 * factorial(9, dpF)) / factorial(9 - i + 1, dpF) // non-leading zeros
    dp[i] += dp[i - 1] // leading zeros
  }

  return dp[n]
}

// n!
function factorial(n: number, dpF: number[]) {
  if (dpF[n]) {
    return dpF[n]
  }

  if (n === 0) {
    dpF[n] = 1
    return 1
  }

  const res = n * factorial(n - 1, dpF)
  dpF[n] = res

  return res
}
