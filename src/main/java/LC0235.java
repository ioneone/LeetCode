package main.java;

public class LC0235 {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    TreeNode low = p.val > q.val ? q : p;
    TreeNode hi = p.val > q.val ? p : q;

    if (root.val == low.val) {
      return low;
    }

    if (root.val == hi.val) {
      return hi;
    }

    if (low.val < root.val && hi.val < root.val && root.left != null) {
      return lowestCommonAncestor(root.left, p, q);
    }

    if (root.val < low.val && root.val < hi.val && root.right != null) {
      return lowestCommonAncestor(root.right, p, q);
    }

    return root;
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

}
