// https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
// dp[i][j]: shortest route from i to j
function findTheCity(
  n: number,
  edges: number[][],
  distanceThreshold: number
): number {
  const dp = [...Array(n)].map((_) => [...Array(n)].fill(Infinity))

  for (let i = 0; i < n; i++) {
    dp[i][i] = 0
  }

  for (let i = 0; i < edges.length; i++) {
    dp[edges[i][0]][edges[i][1]] = edges[i][2]
    dp[edges[i][1]][edges[i][0]] = edges[i][2]
  }

  for (let k = 0; k < n; k++) {
    for (let i = 0; i < n; i++) {
      for (let j = 0; j < n; j++) {
        // shortest path from i to j going through 0...k
        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j])
      }
    }
  }

  let answer = -1
  let minNumReachable = Infinity

  for (let i = 0; i < n; i++) {
    const numReachable =
      dp[i].filter((distance) => distance <= distanceThreshold).length - 1
    if (numReachable <= minNumReachable) {
      minNumReachable = numReachable
      answer = i
    }
  }

  return answer
}
