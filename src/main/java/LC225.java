package main.java;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
 * Implement the MyStack class:
 * 
 * void push(int x) Pushes element x to the top of the stack.
 * int pop() Removes the element on the top of the stack and returns it.
 * int top() Returns the element on the top of the stack.
 * boolean empty() Returns true if the stack is empty, false otherwise.
 * 
 * Notes:
 * 
 * You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
 * Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.
 */
class LC255 {

  private Queue<Integer> queue;

  public LC255() {
    queue = new LinkedList<>();
  }
  
  public void push(int x) {
    int size = queue.size();
    queue.add(x);
    for (int i = 0; i < size; i++) {
      queue.add(queue.remove());
    }
  }
  
  public int pop() {
    return queue.remove();
  }
  
  public int top() {
    return queue.peek();
  }
  
  public boolean empty() {
    return queue.isEmpty();
  }

  public static void main(String[] args) {
    LC255 stack = new LC255();
    stack.push(1);
    stack.push(2);
    stack.push(3);

    System.out.println(stack.pop()); // 3
    System.out.println(stack.pop()); // 2

    stack.push(4);

    System.out.println(stack.pop()); // 4
  }
}