package main.java;

import java.util.Stack;

/**
 * Given two strings s and t, return true if they are equal when both are typed into empty text
 * editors. '#' means a backspace character.
 * 
 * Note that after backspacing an empty text, the text will continue empty.
 */
public class LC844 {
  public static boolean backspaceCompare(String s, String t) {
    Stack<Character> sStack = new Stack<>();
    Stack<Character> tStack = new Stack<>();

    for (char c : s.toCharArray()) {
      if (c == '#') {
        if (!sStack.isEmpty()) {
          sStack.pop();
        }
      } else {
        sStack.add(c);
      }
    }

    for (char c : t.toCharArray()) {
      if (c == '#') {
        if (!tStack.isEmpty()) {
          tStack.pop();
        }
      } else {
        tStack.add(c);
      }
    }

    while (!sStack.isEmpty() && !tStack.isEmpty()) {
      if (sStack.pop() != tStack.pop()) {
        return false;
      }
    }

    return sStack.isEmpty() && tStack.isEmpty();
  }

  public static void main(String[] args) {
    System.out.println(backspaceCompare("ab#c", "ad#c")); // true
    System.out.println(backspaceCompare("ab##", "c#d#")); // true
    System.out.println(backspaceCompare("a#c", "b")); // false
  }
}
