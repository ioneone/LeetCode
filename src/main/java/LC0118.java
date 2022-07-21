package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 */
public class LC0118 {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> ret = new ArrayList<>();

    ret.add(List.of(1));

    for (int i = 1; i < numRows; i++) {
      List<Integer> lastRow = ret.get(i - 1);
      List<Integer> currRow = new ArrayList<>();
      currRow.add(1);
      for (int j = 0; j < lastRow.size() - 1; j++) {
        currRow.add(lastRow.get(j) + lastRow.get(j + 1));
      }
      currRow.add(1);
      ret.add(currRow);
    }

    return ret;
  }

  public static void main(String[] args) {
    LC0118 lc = new LC0118();
    System.out.println(lc.generate(5)); // [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
  }
}
