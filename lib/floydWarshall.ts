// For nodes 0...n-1, returns the minimum distance from any node to any node.
export function floydWarshall(
  n: number,
  edges: {
    from: number
    to: number
    weight: number
  }[]
): number[][] {
  const dp = [...Array(n)].map((_) => [...Array(n)].fill(Infinity))

  for (let i = 0; i < n; i++) {
    dp[i][i] = 0
  }

  for (let i = 0; i < edges.length; i++) {
    dp[edges[i].from][edges[i].to] = edges[i].weight
    dp[edges[i].to][edges[i].from] = edges[i].weight
  }

  for (let k = 0; k < n; k++) {
    for (let i = 0; i < n; i++) {
      for (let j = 0; j < n; j++) {
        // shortest path from i to j going through 0...k
        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j])
      }
    }
  }

  return dp
}
