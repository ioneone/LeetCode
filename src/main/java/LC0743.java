package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of
 * travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the
 * target node, and wi is the time it takes for a signal to travel from source to target.
 * 
 * We will send a signal from a given node k. Return the time it takes for all the n nodes to
 * receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
 */
public class LC0743 {
  public int networkDelayTime(int[][] times, int n, int k) {

    int[] mins = new int[n + 1];

    for (int i = 0; i <= n; i++) {
      mins[i] = -1;
    }

    mins[0] = 0;
    mins[k] = 0;

    Map<Integer, List<Data>> weights = new HashMap<>();

    List<Integer> candidates = new ArrayList<>();

    for (int[] edge : times) {
      int u = edge[0];
      int v = edge[1];
      int w = edge[2];
      List<Data> list = weights.getOrDefault(u, new ArrayList<>());
      list.add(new Data(v, w));
      weights.put(u, list);
    }

    helper(k, mins, weights, 0);

    int max = -1;

    for (int i = 0; i <= n; i++) {
      if (mins[i] == -1) {
        return -1;
      }
      max = Math.max(max, mins[i]);
    }

    return max;
  }

  public void helper(int currentNodeId, int[] mins, Map<Integer, List<Data>> weights,
      int currentWeight) {

    List<Data> neighbors = weights.getOrDefault(currentNodeId, List.of());

    if (neighbors.isEmpty()) {
      return;
    }

    for (Data data : neighbors) {

      int min = mins[data.dst];

      if (min == -1) {
        mins[data.dst] = currentWeight + data.weight;
        helper(data.dst, mins, weights, currentWeight + data.weight);
      } else {
        if (currentWeight + data.weight < min) {
          mins[data.dst] = currentWeight + data.weight;
          helper(data.dst, mins, weights, currentWeight + data.weight);
        }
      }

    }

  }

  public static record Data(int dst, int weight) {
  }

  public static void main(String[] args) {
    LC0743 lc = new LC0743();
    int[] nums1 = new int[] {2, 1, 1};
    int[] nums2 = new int[] {2, 3, 1};
    int[] nums3 = new int[] {3, 4, 1};
    int[][] nums = new int[3][3];
    nums[0] = nums1;
    nums[1] = nums2;
    nums[2] = nums3;

    System.out.println(lc.networkDelayTime(nums, 4, 2)); // 2
  }
}
