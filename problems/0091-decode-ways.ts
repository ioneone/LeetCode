// https://leetcode.com/problems/decode-ways/
function numDecodings(s: string): number {
  return numDecodingsHelper(s, 0, {})
}

function numDecodingsHelper(
  s: string,
  i: number,
  memory: Record<number, number>
): number {
  if (memory[i] != null) {
    return memory[i]
  }

  if (i >= s.length) {
    return 1
  }

  if (s[i] === "0") {
    return 0
  }

  let res = 0

  // case 1: pick 1 digit
  res += numDecodingsHelper(s, i + 1, memory)

  // case 2: pick 2 digits
  if (i + 1 < s.length && Number(s.slice(i, i + 2)) <= 26) {
    res += numDecodingsHelper(s, i + 2, memory)
  }

  memory[i] = res

  return res
}
