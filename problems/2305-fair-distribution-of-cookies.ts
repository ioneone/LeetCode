function distributeCookies(cookies: number[], k: number): number {
  const buckets = [...Array(k)].fill(0)

  return distributeCookiesHelper(cookies, k, 0, buckets, 0)
}

function distributeCookiesHelper(
  cookies: number[],
  k: number,
  pointer: number,
  buckets: number[],
  maxSoFar: number
) {
  if (pointer === cookies.length) {
    return maxSoFar
  }

  let min = Infinity
  for (let i = 0; i < buckets.length; i++) {
    buckets[i] += cookies[pointer]
    min = Math.min(
      min,
      distributeCookiesHelper(
        cookies,
        k,
        pointer + 1,
        buckets,
        Math.max(maxSoFar, buckets[i])
      )
    )
    buckets[i] -= cookies[pointer]
  }

  return min
}
