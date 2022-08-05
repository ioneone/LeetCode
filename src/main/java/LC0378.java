package main.java;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the
 * kth smallest element in the matrix.
 * 
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * 
 * You must find a solution with a memory complexity better than O(n2).
 */
public class LC0378 {

  public int kthSmallest(int[][] matrix, int k) {
    Set<String> visited = new HashSet<>();
    Queue<Data> minHeap = new PriorityQueue<>(
        (Data data1, Data data2) -> matrix[data1.i][data1.j] - matrix[data2.i][data2.j]);

    visited.add("0,0");
    minHeap.add(new Data(0, 0));

    Data data = null;
    for (int i = 0; i < k; i++) {
      data = minHeap.poll();
      if (data.i + 1 < matrix.length && !visited.contains((data.i + 1) + "," + data.j)) {
        minHeap.add(new Data(data.i + 1, data.j));
        visited.add((data.i + 1) + "," + data.j);
      }

      if (data.j + 1 < matrix[0].length && !visited.contains(data.i + "," + (data.j + 1))) {
        minHeap.add(new Data(data.i, data.j + 1));
        visited.add(data.i + "," + (data.j + 1));
      }
    }

    return matrix[data.i][data.j];
  }

  public static class Data {
    public final int i;
    public final int j;

    public Data(int i, int j) {
      this.i = i;
      this.j = j;
    }
  }

  public static void main(String[] args) {

  }

}
