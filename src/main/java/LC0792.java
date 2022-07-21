package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string s and an array of strings words, return the number of words[i] that is a
 * subsequence of s.
 * 
 * A subsequence of a string is a new string generated from the original string with some characters
 * (can be none) deleted without changing the relative order of the remaining characters.
 * 
 * For example, "ace" is a subsequence of "abcde".
 */
public class LC0792 {
  public int numMatchingSubseq(String s, String[] words) {
    Map<Character, List<Integer>> indices = new HashMap<>();
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      List<Integer> list = indices.getOrDefault(chars[i], new ArrayList<>());
      list.add(i);
      indices.put(chars[i], list);
    }

    int count = 0;

    for (String word : words) {
      Map<Character, Integer> nextPointers = new HashMap<>();
      int currentPointer = -1;
      char[] wordChars = word.toCharArray();

      for (int i = 0; i < wordChars.length; i++) {
        List<Integer> list = indices.getOrDefault(wordChars[i], List.of());
        Integer nextPointer = nextPointers.getOrDefault(wordChars[i], 0);

        boolean isFound = false;
        while (nextPointer < list.size()) {
          if (list.get(nextPointer) > currentPointer) {
            currentPointer = list.get(nextPointer);
            nextPointer++;
            isFound = true;
            break;
          } else {
            nextPointer++;
          }
        }

        nextPointers.put(wordChars[i], nextPointer);

        if (!isFound) {
          currentPointer = -1;
          break;
        }

      }

      if (currentPointer != -1) {
        count++;
      }
    }

    return count;
  }

  public static void main(String[] args) {
    LC0792 lc = new LC0792();
    System.out.println(lc.numMatchingSubseq("abcde", new String[] {"a", "bb", "acd", "ace"})); // 3
    System.out.println(lc.numMatchingSubseq("dsahjpjauf",
        new String[] {"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"})); // 2
  }
}
