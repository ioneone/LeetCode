// https://leetcode.com/problems/minimum-sideway-jumps/
// dp1[k] = min side jumps required to reach point k at lane 1
// dp2[k] = min side jumps required to reach point k at lane 2
// dp3[k] = min side jumps required to reach point k at lane 3
// n = obstacles.length
// answer = min(dp1[n - 1], dp2[n - 1], dp3[n - 1])
// dp1[k] = if obstacles[k] === 1 then Infinity
//          else min(dp1[k - 1], dp2[k - 1] + 1, dp3[k - 1] + 1)
// dp2[k] = if obstacles[k] === 2 then Infinity
//          else min(dp1[k - 1] + 1, dp2[k - 1], dp3[k - 1] + 1)
// dp3[k] = if obstacles[k] === 3 then Infinity
//          else min(dp1[k - 1] + 1, dp2[k - 1] + 1, dp3[k - 1])
function minSideJumps(obstacles: number[]): number {
  const dp1 = [...Array(obstacles.length)]
  const dp2 = [...Array(obstacles.length)]
  const dp3 = [...Array(obstacles.length)]

  dp1[0] = 1
  dp2[0] = 0
  dp3[0] = 1

  for (let i = 1; i < obstacles.length; i++) {
    dp1[i] = Math.min(
      dp1[i - 1],
      obstacles[i] === 2 ? Infinity : dp2[i - 1] + 1,
      obstacles[i] === 3 ? Infinity : dp3[i - 1] + 1
    )
    dp2[i] = Math.min(
      obstacles[i] === 1 ? Infinity : dp1[i - 1] + 1,
      dp2[i - 1],
      obstacles[i] === 3 ? Infinity : dp3[i - 1] + 1
    )
    dp3[i] = Math.min(
      obstacles[i] === 1 ? Infinity : dp1[i - 1] + 1,
      obstacles[i] === 2 ? Infinity : dp2[i - 1] + 1,
      dp3[i - 1]
    )

    if (obstacles[i] === 1) {
      dp1[i] = Infinity
    } else if (obstacles[i] === 2) {
      dp2[i] = Infinity
    } else if (obstacles[i] === 3) {
      dp3[i] = Infinity
    }
  }

  return Math.min(
    dp1[obstacles.length - 1],
    dp2[obstacles.length - 1],
    dp3[obstacles.length - 1]
  )
}
