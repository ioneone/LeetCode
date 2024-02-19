function minOperations(n: number): number {
  let answer = 0
  while (n > 0) {
    if ((n & 3) === 3) {
      n += 1
      answer += 1
      n = n >> 2
    } else {
      if ((n & 1) === 1) {
        answer += 1
      }
      n = n >> 1
    }
  }

  return answer
}
