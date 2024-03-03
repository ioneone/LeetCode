// https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/

import { floydWarshall } from "../lib/floydWarshall"

// dp[i][j]: shortest route from i to j
function findTheCity(
  n: number,
  edges: number[][],
  distanceThreshold: number
): number {
  const dp = floydWarshall(
    n,
    edges.map(([from, to, weight]) => ({ from, to, weight }))
  )

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
