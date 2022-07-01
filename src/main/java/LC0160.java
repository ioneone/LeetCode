package main.java;

import java.util.HashSet;
import java.util.Set;

public class LC0160 {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    Set<ListNode> visitedA = new HashSet<>();

    ListNode currentNode = headA;
    while (currentNode != null) {
      visitedA.add(currentNode);
      currentNode = currentNode.next;
    }

    currentNode = headB;
    while (currentNode != null) {
      if (visitedA.contains(currentNode)) {
        return currentNode;
      }
      currentNode = currentNode.next;
    }

    return null;
  }

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

}
