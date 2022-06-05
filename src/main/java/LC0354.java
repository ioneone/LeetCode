package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width
 * and the height of an envelope.
 * 
 * One envelope can fit into another if and only if both the width and height of one envelope are
 * greater than the other envelope's width and height.
 * 
 * Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).
 * 
 * Note: You cannot rotate an envelope.
 */
public class LC0354 {
  public int maxEnvelopes(int[][] envelopes) {
    List<Envelope> list = new ArrayList<>();
    for (int i = 0; i < envelopes.length; i++) {
      list.add(new Envelope(envelopes[i][0], envelopes[i][1]));
    }

    list.sort((Envelope e1, Envelope e2) -> e1.width * e1.height - e2.width * e2.height);

    if (list.isEmpty()) {
      return 0;
    }

    // dp[i] = max envelopes from list[0] to list[i]
    // dp[i] = max(dp[k] + 1 if list[i] is bigger than list[k] else 0) for k = 0...i-1
    int[] dp = new int[list.size()];
    int max = 1;
    dp[0] = 1;
    for (int i = 1; i < dp.length; i++) {
      dp[i] = 1;
      for (int j = 0; j < i; j++) {
        Envelope ei = list.get(i);
        Envelope ej = list.get(j);
        if (ei.width > ej.width && ei.height > ej.height) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
          max = Math.max(max, dp[i]);
        }
      }
    }

    return max;
  }

  public record Envelope(int width, int height) {
  }

  public static void main(String[] args) {
    LC0354 lc = new LC0354();
    System.out.println(lc.maxEnvelopes(
        new int[][] {new int[] {5, 4}, new int[] {6, 4}, new int[] {6, 7}, new int[] {2, 3}})); // 3
    System.out.println(
        lc.maxEnvelopes(new int[][] {new int[] {1, 1}, new int[] {1, 1}, new int[] {1, 1}})); // 1
  }
}
