package main.java;

public class LC0092 {

  public static class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public ListNode reverseBetween(ListNode head, int left, int right) {
    ListNode leftNode = null;
    ListNode rightNode = null;
    ListNode leftOfLeft = null;
    ListNode rightOfRight = null;

    int currentIndex = 1;
    ListNode prevNode = null;
    ListNode currNode = head;

    while (currentIndex <= right) {
      ListNode nextNode = currNode.next;
      if (currentIndex > left) {
        currNode.next = prevNode;
      }

      if (currentIndex == left) {
        leftNode = currNode;
        leftOfLeft = prevNode;
      }

      if (currentIndex == right) {
        rightNode = currNode;
        rightOfRight = nextNode;
      }

      currentIndex++;
      prevNode = currNode;
      currNode = nextNode;
    }

    if (leftOfLeft != null) {
      leftOfLeft.next = rightNode;
    }

    leftNode.next = rightOfRight;

    if (left == 1) {
      return rightNode;
    } else {
      return head;
    }
  }

  public static void main(String[] args) {
    LC0092 lc = new LC0092();

    ListNode node1 = new ListNode();
    node1.val = 1;

    ListNode node2 = new ListNode();
    node2.val = 2;

    ListNode node3 = new ListNode();
    node3.val = 3;

    ListNode node4 = new ListNode();
    node4.val = 4;

    ListNode node5 = new ListNode();
    node5.val = 5;

    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;

    ListNode node = lc.reverseBetween(node1, 2, 4);

    while (node != null) {
      System.out.print(node.val);
      System.out.print("->");
      node = node.next;
    }
    System.out.println();

    // [1,4,3,2,5]
  }
}
