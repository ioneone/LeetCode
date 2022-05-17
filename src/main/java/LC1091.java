package main.java;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If
 * there is no clear path, return -1.
 * 
 * A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the
 * bottom-right cell (i.e., (n - 1, n - 1)) such that:
 * 
 * All the visited cells of the path are 0. All the adjacent cells of the path are 8-directionally
 * connected (i.e., they are different and they share an edge or a corner). The length of a clear
 * path is the number of visited cells of this path.
 */
public class LC1091 {

  public int shortestPathBinaryMatrix(int[][] grid) {

    if (grid[0][0] == 1) {
      return -1;
    }

    Set<Node> visited = new HashSet<>();
    Queue<Data> queue = new LinkedList<>();

    queue.add(new Data(new Node(0, 0), 1));

    while (!queue.isEmpty()) {

      Data data = queue.remove();
      Node node = data.node;

      if (node.i == grid.length - 1 && node.j == grid.length - 1) {
        return data.distance;
      }

      visited.add(node);

      // check all 8 directions
      // right
      if (node.j + 1 < grid.length && grid[node.i][node.j + 1] == 0
          && !visited.contains(new Node(node.i, node.j + 1))) {
        queue.add(new Data(new Node(node.i, node.j + 1), data.distance + 1));
      }
      // bottom-right
      if (node.i + 1 < grid.length && node.j + 1 < grid.length && grid[node.i + 1][node.j + 1] == 0
          && !visited.contains(new Node(node.i + 1, node.j + 1))) {
        queue.add(new Data(new Node(node.i + 1, node.j + 1), data.distance + 1));
      }
      // bottom
      if (node.i + 1 < grid.length && grid[node.i + 1][node.j] == 0
          && !visited.contains(new Node(node.i + 1, node.j))) {
        queue.add(new Data(new Node(node.i + 1, node.j), data.distance + 1));
      }
      // bottom-left
      if (node.i + 1 < grid.length && node.j - 1 >= 0 && grid[node.i + 1][node.j - 1] == 0
          && !visited.contains(new Node(node.i + 1, node.j - 1))) {
        queue.add(new Data(new Node(node.i + 1, node.j - 1), data.distance + 1));
      }
      // left
      if (node.j - 1 >= 0 && grid[node.i][node.j - 1] == 0
          && !visited.contains(new Node(node.i, node.j - 1))) {
        queue.add(new Data(new Node(node.i, node.j - 1), data.distance + 1));
      }
      // top-left
      if (node.i - 1 >= 0 && node.j - 1 >= 0 && grid[node.i - 1][node.j - 1] == 0
          && !visited.contains(new Node(node.i - 1, node.j - 1))) {
        queue.add(new Data(new Node(node.i - 1, node.j - 1), data.distance + 1));
      }
      // top
      if (node.i - 1 >= 0 && grid[node.i - 1][node.j] == 0
          && !visited.contains(new Node(node.i - 1, node.j))) {
        queue.add(new Data(new Node(node.i - 1, node.j), data.distance + 1));
      }
      // top-right
      if (node.i - 1 >= 0 && node.j + 1 < grid.length && grid[node.i - 1][node.j + 1] == 0
          && !visited.contains(new Node(node.i - 1, node.j + 1))) {
        queue.add(new Data(new Node(node.i - 1, node.j + 1), data.distance + 1));
      }
    }

    return -1;
  }

  public static record Data(Node node, int distance) {
  }

  public static record Node(int i, int j) {
  }

  public static void main(String[] args) {
    int[][] grid = new int[3][3];
    grid[0] = new int[] {0, 0, 0};
    grid[1] = new int[] {1, 1, 0};
    grid[2] = new int[] {1, 1, 0};

    Set<Node> visited = new HashSet<>();
    visited.add(new Node(0, 1));
    System.out.println(visited.contains(new Node(0, 1))); // true
    System.out.println(visited.contains(new Node(0, 0))); // false


    LC1091 lc = new LC1091();
    System.out.println(lc.shortestPathBinaryMatrix(grid)); // 4
  }

}
