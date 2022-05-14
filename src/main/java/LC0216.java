package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are
 * true:
 * 
 * Only numbers 1 through 9 are used. Each number is used at most once. Return a list of all
 * possible valid combinations. The list must not contain the same combination twice, and the
 * combinations may be returned in any order.
 */
public class LC216 {

  public static List<List<Integer>> combinationSum3(int k, int n) {
    return helper(k, n, 1, new ArrayList<>());
  }

  public static List<List<Integer>> helper(int k, int n, int m, List<Integer> list) {
    List<List<Integer>> ret = new ArrayList<>();

    if (n < 0) {
      return ret;
    }

    if (k == 0) {
      if (n == 0) {
        ret.add(new ArrayList<>(list));
      }
      return ret;
    }

    for (int i = m; i <= 9; i++) {
      list.add(i);
      ret.addAll(helper(k - 1, n - i, i + 1, list));
      list.remove(list.size() - 1);
    }

    return ret;

  }

  public static void main(String[] args) {
    System.out.println(combinationSum3(3, 7)); // [[1,2,4]]
    System.out.println(combinationSum3(3, 9)); // [[1,2,6],[1,3,5],[2,3,4]]
    System.out.println(combinationSum3(4, 1)); // []
  }

}
