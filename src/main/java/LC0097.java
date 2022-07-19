package main.java;

/**
 * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
 * 
 * An interleaving of two strings s and t is a configuration where they are divided into non-empty
 * substrings such that:
 * 
 * s = s1 + s2 + ... + sn t = t1 + t2 + ... + tm |n - m| <= 1 The interleaving is s1 + t1 + s2 + t2
 * + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ... Note: a + b is the concatenation of strings
 * a and b.
 */
public class LC0097 {

  public boolean isInterleave(String s1, String s2, String s3) {
    char[] c1 = s1.toCharArray();
    char[] c2 = s2.toCharArray();
    char[] c3 = s3.toCharArray();

    return helper(c1, c2, c3, 0, 0, 0);
  }

  public boolean helper(char[] c1, char[] c2, char[] c3, int p1, int p2, int p3) {
    if (c3.length <= p3) {
      return c1.length <= p1 && c2.length <= p2;
    }

    if (p1 < c1.length && c1[p1] == c3[p3]) {
      if (helper(c1, c2, c3, p1 + 1, p2, p3 + 1)) {
        return true;
      }
    }

    if (p2 < c2.length && c2[p2] == c3[p3]) {
      if (helper(c1, c2, c3, p1, p2 + 1, p3 + 1)) {
        return true;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    LC0097 lc = new LC0097();
    System.out.println(lc.isInterleave("aabcc", "dbbca", "aadbbcbcac")); // true
    System.out.println(lc.isInterleave("aabcc", "dbbca", "aadbbbaccc")); // false
    System.out.println(lc.isInterleave("", "", "")); // true
  }

}
