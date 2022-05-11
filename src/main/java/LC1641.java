package main.java;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer n, return the number of strings of length n that consist only of vowels (a, e,
 * i, o, u) and are lexicographically sorted.
 * 
 * A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before
 * s[i+1] in the alphabet.
 */
public class LC1641 {

  public Map<Integer, Integer> cacheE = new HashMap<>();
  public Map<Integer, Integer> cacheI = new HashMap<>();
  public Map<Integer, Integer> cacheO = new HashMap<>();
  public Map<Integer, Integer> cacheU = new HashMap<>();

  public int countVowelStrings(int n) {
    return a(n) + e(n) + i(n) + o(n) + u(n);
  }

  public int a(int n) {
    return 1;
  }

  public int e(int n) {
    if (n == 1) {
      return 1;
    }

    Integer cachedE = cacheE.get(n);
    if (cachedE != null) {
      return cachedE;
    }

    int val = e(n - 1) + a(n - 1);
    cacheE.put(n, val);
    return val;
  }

  public int i(int n) {
    if (n == 1) {
      return 1;
    }

    Integer cachedI = cacheI.get(n);
    if (cachedI != null) {
      return cachedI;
    }

    int val = i(n - 1) + e(n);
    cacheI.put(n, val);
    return val;
  }

  public int o(int n) {
    if (n == 1) {
      return 1;
    }

    Integer cachedO = cacheO.get(n);
    if (cachedO != null) {
      return cachedO;
    }

    int val = o(n - 1) + i(n);
    cacheO.put(n, val);
    return val;
  }

  public int u(int n) {
    if (n == 1) {
      return 1;
    }

    Integer cachedU = cacheU.get(n);
    if (cachedU != null) {
      return cachedU;
    }

    int val = u(n - 1) + o(n);
    cacheU.put(n, val);
    return val;
  }

  public static void main(String[] args) {
    LC1641 lc = new LC1641();
    System.out.println(lc.countVowelStrings(1)); // 5
    System.out.println(lc.countVowelStrings(2)); // 15
    System.out.println(lc.countVowelStrings(33)); // 66045
  }
}
