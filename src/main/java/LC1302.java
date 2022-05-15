package main.java;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the sum of values of its deepest leaves.
 */
public class LC1302 {

  public int deepestLeavesSum(TreeNode root) {

    int currentLevel = 1;
    int currentSum = 0;

    Queue<MyTreeNode> nodes = new LinkedList<>();
    nodes.add(new MyTreeNode(root, currentLevel));

    while (!nodes.isEmpty()) {
      MyTreeNode node = nodes.remove();
      if (node.level == currentLevel) {
        currentSum += node.node.val;
      } else {
        currentLevel = node.level;
        currentSum = node.node.val;
      }
      if (node.node.left != null) {
        nodes.add(new MyTreeNode(node.node.left, node.level + 1));
      }
      if (node.node.right != null) {
        nodes.add(new MyTreeNode(node.node.right, node.level + 1));
      }
    }

    return currentSum;
  }

  public class MyTreeNode {
    TreeNode node;
    int level;

    public MyTreeNode(TreeNode node, int level) {
      this.node = node;
      this.level = level;
    }
  }

  // Definition for a binary tree node.
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
