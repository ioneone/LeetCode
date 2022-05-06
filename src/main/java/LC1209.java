package main.java;

import java.util.Stack;

/**
 * You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.
 * 
 * We repeatedly make k duplicate removals on s until we no longer can.
 * 
 * Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.
 */
public class LC1209 {

  private static class Data {
    private char c;
    private int count;

    public Data(char c, int count) {
      this.c = c;
      this.count = count;
    }    
  }

  public static String removeDuplicates(String s, int k) {
    Stack<Data> stack = new Stack<>();

    for (char c : s.toCharArray()) {

      if (stack.isEmpty()) {
        stack.push(new Data(c, 1));
        continue;
      }

      Data data = stack.peek();
      if (data.c == c) {
        
        if (data.count == k - 1) {
          stack.pop();
        } else {
          stack.push(new Data(c, stack.pop().count + 1));
        }

      } else {
        stack.push(new Data(c, 1));
      } 

    }

    StringBuilder ret = new StringBuilder();

    while (!stack.isEmpty()) {
      Data data = stack.pop();
      for (int i = 0; i < data.count; i++) {
        ret = ret.insert(0, data.c);
      }
    }

    return ret.toString();
  }
  
  public static void main(String[] args) {
    System.out.println(removeDuplicates("abcd", 2)); // abcd
    System.out.println(removeDuplicates("deeedbbcccbdaa", 3)); // aa
    System.out.println(removeDuplicates("pbbcggttciiippooaais", 2)); // ps
  }
}
