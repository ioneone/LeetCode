// https://leetcode.com/problems/matchsticks-to-square/
function makesquare(matchsticks: number[]): boolean {
  const sum = matchsticks.reduce((a, b) => a + b, 0)

  if (sum % 4 !== 0) {
    return false
  }

  return canBeSplitInto4Buckets(matchsticks, sum / 4)
}

function canBeSplitInto4Buckets(arr: number[], target: number) {
  // Sorting the input array DESC will make the DFS process run much faster.
  // Reason behind this is we always try to put the next matchstick in the
  // first subset. If there is no solution, trying a longer matchstick first
  // will get to negative conclusion earlier.
  return canBeSplitInto4BucketsHelper(
    arr.sort((a, b) => b - a),
    target,
    0,
    [0, 0, 0, 0]
  )
}

function canBeSplitInto4BucketsHelper(
  arr: number[],
  target: number,
  pointer: number,
  sums: number[]
) {
  if (pointer === arr.length) {
    return (
      sums[0] === target &&
      sums[1] === target &&
      sums[2] === target &&
      sums[3] === target
    )
  }

  if (
    sums[0] > target ||
    sums[1] > target ||
    sums[2] > target ||
    sums[3] > target
  ) {
    return false
  }

  for (let i = 0; i < 4; i++) {
    sums[i] += arr[pointer]
    if (canBeSplitInto4BucketsHelper(arr, target, pointer + 1, sums)) {
      return true
    }
    sums[i] -= arr[pointer]
  }

  return false
}
