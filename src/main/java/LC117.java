package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree
 * 
 * Populate each next pointer to point to its next right node. If there is no next right node, the
 * next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 */
public class LC117 {
  public Node connect(Node root) {
    if (root == null) {
      return null;
    }

    List<List<Node>> nodes = new ArrayList<>();

    traverseLeftToRight(root, 0, nodes);

    for (List<Node> nodeList : nodes) {

      for (int i = 0; i < nodeList.size() - 1; i++) {
        nodeList.get(i).next = nodeList.get(i + 1);
      }

    }

    return root;
  }

  public void traverseLeftToRight(Node node, int level, List<List<Node>> nodes) {

    if (nodes.size() == level) {
      nodes.add(new ArrayList<>());
    }

    nodes.get(level).add(node);

    if (node.left != null) {
      traverseLeftToRight(node.left, level + 1, nodes);
    }

    if (node.right != null) {
      traverseLeftToRight(node.right, level + 1, nodes);
    }
  }

  public static class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }
  };

  public static void main(String[] args) {

    Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(4);
    Node node5 = new Node(5);
    Node node7 = new Node(7);

    node1.left = node2;
    node1.right = node3;

    node2.left = node4;
    node2.right = node5;

    node3.right = node7;

    LC117 lc = new LC117();
    lc.connect(node1);

    System.out.println(node1.next); // null
    System.out.println(node2.next.val); // 3
    System.out.println(node3.next); // null
    System.out.println(node4.next.val); // 5
    System.out.println(node5.next.val); // 7
    System.out.println(node7.next); // null
  }
}
