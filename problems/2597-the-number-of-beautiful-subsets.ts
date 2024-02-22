function beautifulSubsets(nums: number[], k: number): number {
  // keep track of invalid numbers
  const invalid: Record<number, number> = {}
  // keep track of currently picked items
  let arr = []

  return beautifulSubsetsHelper(nums, k, 0, invalid, arr)
}

// beautifulSubsets for nums[pointer...nums.length-1]
function beautifulSubsetsHelper(
  nums: number[],
  k: number,
  pointer: number,
  invalid: Record<number, number>,
  arr: number[]
): number {
  if (pointer === nums.length) {
    return arr.length > 0 ? 1 : 0
  }

  let answer = 0

  // case 1: take it
  if (!invalid[nums[pointer]]) {
    arr.push(nums[pointer])
    invalid[nums[pointer] + k] = (invalid[nums[pointer] + k] ?? 0) + 1
    invalid[nums[pointer] - k] = (invalid[nums[pointer] - k] ?? 0) + 1

    answer += beautifulSubsetsHelper(nums, k, pointer + 1, invalid, arr)

    arr.pop()
    invalid[nums[pointer] + k] = invalid[nums[pointer] + k] - 1
    invalid[nums[pointer] - k] = invalid[nums[pointer] - k] - 1
  }

  // case 2: skip it
  answer += beautifulSubsetsHelper(nums, k, pointer + 1, invalid, arr)

  return answer
}
