// https://leetcode.com/problems/video-stitching/
function videoStitching(clips: number[][], time: number): number {
  const sortedClips = [...clips].sort((a, b) => {
    if (a[0] !== b[0]) {
      return a[0] - b[0]
    } else {
      return a[1] - b[1]
    }
  })

  let answer = 0
  let prevEnd = 0
  let end = 0
  for (let i = 0; i < sortedClips.length; i++) {
    const clip = sortedClips[i]

    if (end < clip[0]) {
      return -1
    }

    if (clip[0] <= prevEnd) {
      end = Math.max(end, clip[1])
    } else {
      answer += 1
      prevEnd = end
      end = Math.max(end, clip[1])
    }

    if (time <= end) {
      break
    }
  }

  answer += 1

  return time <= end ? answer : -1
}
