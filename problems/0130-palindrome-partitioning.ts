// https://leetcode.com/problems/palindrome-partitioning/
function partition(s: string): string[][] {
  const partition: string[] = []
  const answer: string[][] = []

  partitionHelper(s, partition, answer)

  return answer
}

// s: next string to partition
// partition: partitions extracted from original s so far
// answer: the accumulator for partition
function partitionHelper(s: string, partition: string[], answer: string[][]) {
  if (s.length === 0) {
    answer.push(partition.slice())
    return
  }

  for (let i = 1; i <= s.length; i++) {
    const substring = s.slice(0, i)
    if (isPalindrome(substring)) {
      partition.push(substring)
      partitionHelper(s.slice(i), partition, answer)
      partition.pop()
    }
  }
}

function isPalindrome(s: string): boolean {
  let leftPointer = 0
  let rightPointer = s.length - 1

  while (leftPointer < rightPointer) {
    if (s[leftPointer] !== s[rightPointer]) {
      return false
    }

    leftPointer += 1
    rightPointer -= 1
  }

  return true
}
