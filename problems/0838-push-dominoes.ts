// https://leetcode.com/problems/push-dominoes/
function pushDominoes(dominoes: string): string {
  const rightForces = [...Array(dominoes.length)].fill(0)
  const leftForces = [...Array(dominoes.length)].fill(0)

  let currForce = null

  for (let i = 0; i < dominoes.length; i++) {
    if (dominoes[i] === "R") {
      currForce = dominoes.length
      rightForces[i] = currForce
    } else if (dominoes[i] === "L") {
      currForce = null
    } else {
      if (currForce != null) {
        rightForces[i] = currForce
      }
    }

    if (currForce != null) {
      currForce -= 1
    }
  }

  for (let i = dominoes.length - 1; i >= 0; i--) {
    if (dominoes[i] === "L") {
      currForce = dominoes.length
      leftForces[i] = currForce
    } else if (dominoes[i] === "R") {
      currForce = null
    } else {
      if (currForce != null) {
        leftForces[i] = currForce
      }
    }

    if (currForce != null) {
      currForce -= 1
    }
  }

  const answer = [...Array(dominoes.length)]

  for (let i = 0; i < dominoes.length; i++) {
    if (rightForces[i] > leftForces[i]) {
      answer[i] = "R"
    } else if (rightForces[i] < leftForces[i]) {
      answer[i] = "L"
    } else {
      answer[i] = "."
    }
  }

  return answer.join("")
}
