package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that
 * the number could represent. Return the answer in any order.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1
 * does not map to any letters.
 * 
 * 2 -> abc
 * 
 * 3 -> def
 * 
 * 4 -> ghi
 * 
 * 5 -> jkl
 * 
 * 6 -> mno
 * 
 * 7 -> pqrs
 * 
 * 8 -> tuv
 * 
 * 9 -> wxyz
 */
public class LC17 {

  private static final Map<Character, List<Character>> MAP = Map.of('2', List.of('a', 'b', 'c'),
      '3', List.of('d', 'e', 'f'), '4', List.of('g', 'h', 'i'), '5', List.of('j', 'k', 'l'), '6',
      List.of('m', 'n', 'o'), '7', List.of('p', 'q', 'r', 's'), '8', List.of('t', 'u', 'v'), '9',
      List.of('w', 'x', 'y', 'z'));


  public static List<String> letterCombinations(String digits) {
    if (digits.length() == 0) {
      return List.of();
    }

    return compute(digits.toCharArray(), 0, "");
  }

  public static List<String> compute(char[] digits, int index, String prefix) {
    List<String> ret = new ArrayList<>();

    if (index >= digits.length) {
      ret.add(prefix);
      return ret;
    }

    for (char c : MAP.get(digits[index])) {
      ret.addAll(compute(digits, index + 1, prefix + c));
    }

    return ret;
  }

  public static void main(String[] args) {
    System.out.println(letterCombinations("23")); // ["ad","ae","af","bd","be","bf","cd","ce","cf"]
    System.out.println(letterCombinations("")); // []
    System.out.println(letterCombinations("2")); // ["a","b","c"]
  }

}
