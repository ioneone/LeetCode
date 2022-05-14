package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique
 * permutations in any order.
 */
public class LC47 {
  public List<List<Integer>> permuteUnique(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    Set<Integer> keys = new HashSet<>();

    for (int num : nums) {
      int count = map.getOrDefault(num, 0);
      map.put(num, count + 1);
      keys.add(num);
    }

    return helper(map, keys, new ArrayList<>());
  }

  public List<List<Integer>> helper(Map<Integer, Integer> map, Set<Integer> keys,
      List<Integer> list) {

    List<List<Integer>> ret = new ArrayList<>();

    if (keys.isEmpty()) {
      ret.add(List.copyOf(list));
      return ret;
    }

    for (int key : Set.copyOf(keys)) {
      list.add(key);
      map.put(key, map.get(key) - 1);
      if (map.get(key) == 0) {
        keys.remove(key);
      }
      ret.addAll(helper(map, keys, list));
      if (map.get(key) == 0) {
        keys.add(key);
      }
      map.put(key, map.get(key) + 1);
      list.remove(list.size() - 1);
    }



    return ret;
  }

  public static void main(String[] args) {
    LC47 lc = new LC47();
    System.out.println(lc.permuteUnique(new int[] {1, 1, 2})); // [[1,1,2], [1,2,1], [2,1,1]]
    System.out.println(lc.permuteUnique(new int[] {1, 2, 3})); // [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
  }
}
