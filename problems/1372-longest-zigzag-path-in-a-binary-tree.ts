// https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/

/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */

function longestZigZag(root: TreeNode | null): number {
  const mem = { maxLengthSoFar: 0 }

  longestZigZagHelper(root, true, 0, mem)
  longestZigZagHelper(root, false, 0, mem)

  return mem.maxLengthSoFar
}

function longestZigZagHelper(
  root: TreeNode | null,
  goLeft: boolean,
  length: number,
  mem: { maxLengthSoFar: number }
) {
  if (root == null) {
    return
  }

  mem.maxLengthSoFar = Math.max(mem.maxLengthSoFar, length)

  if (goLeft) {
    longestZigZagHelper(root.left, false, length + 1, mem)
    longestZigZagHelper(root.right, true, 1, mem)
  } else {
    longestZigZagHelper(root.right, true, length + 1, mem)
    longestZigZagHelper(root.left, false, 1, mem)
  }
}
