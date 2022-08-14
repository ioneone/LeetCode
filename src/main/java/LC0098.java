package main.java;

public class LC0098 {

  public boolean isValidBST(TreeNode root) {
    boolean isLeftValidBST = root.left == null || isValidBST(root.left, null, root.val);
    boolean isRightValidBST = root.right == null || isValidBST(root.right, root.val, null);
    return isLeftValidBST && isRightValidBST;
  }

  public boolean isValidBST(TreeNode root, Integer minVal, Integer maxVal) {
    if ((minVal != null && minVal >= root.val) || (maxVal != null && root.val >= maxVal)) {
      return false;
    }

    boolean isLeftValidBST = root.left == null || isValidBST(root.left, minVal, root.val);
    boolean isRightValidBST = root.right == null || isValidBST(root.right, root.val, maxVal);

    return isLeftValidBST && isRightValidBST;
  }

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
