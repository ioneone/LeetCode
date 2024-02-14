// dp1[k]: num tiling for 2 x k board
// dp2[k]: num titing for 2 x k board, that's missing top right
// xxxx
// xxxxx
// dp3[k]: num tiling for 2 x k board, that's missing bottom right
// xxxxx
// xxxx
// answer = dp1[n]
// dp1[k] = dp1[k - 1] + dp2[k - 1] + dp3[k - 1]
// case 1: dp1[k - 1]
// xxxxxxxy
// xxxxxxxy
//
// case 2: dp3[k - 1]
// xxxxxxxy
// xxxxxxyy
//
// case 3: dp2[k - 1]
// xxxxxxyy
// xxxxxxxy
// case 4: dp1[k - 2]
// xxxxxxyy
// xxxxxxyy
//
// dp2[k] = dp3[k - 1] + dp1[k - 2]
// case 1
// xxxxxx
// xxxxxyy
// case 2
// xxxxxy
// xxxxxyy
// dp3[k] = dp2[k - 1] + dp1[k - 2]
// case 1
// xxxxxyy
// xxxxxx
// case 2
// xxxxxyy
// xxxxxy
function numTilings(n: number): number {
  if (n === 1) {
    return 1
  }

  if (n === 2) {
    return 2
  }

  const mod = Math.pow(10, 9) + 7

  const dp1 = [...Array(n + 1)]
  const dp2 = [...Array(n + 1)]
  const dp3 = [...Array(n + 1)]

  dp1[1] = 1
  dp2[1] = 0
  dp3[1] = 0

  dp1[2] = 2
  dp2[2] = 1
  dp3[2] = 1

  // dp1[3] = 5
  // dp2[3] = 2
  // dp3[3] = 2

  for (let k = 3; k <= n; k++) {
    dp1[k] = (dp1[k - 1] + dp2[k - 1] + dp3[k - 1] + dp1[k - 2]) % mod
    dp2[k] = (dp3[k - 1] + dp1[k - 2]) % mod
    dp3[k] = (dp2[k - 1] + dp1[k - 2]) % mod
  }

  return dp1[n]
}
