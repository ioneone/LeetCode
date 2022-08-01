package main.java;

/**
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e.,
 * grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The
 * robot can only move either down or right at any point in time.
 * 
 * Given the two integers m and n, return the number of possible unique paths that the robot can
 * take to reach the bottom-right corner.
 * 
 * The test cases are generated so that the answer will be less than or equal to 2 * 109.
 */
public class LC0062 {

  public int uniquePaths(int m, int n) {
    // dp[i][j]: unique paths from grid[0][0] to grid[i][j]
    int[][] dp = new int[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 && j == 0) {
          dp[0][0] = 1;
        } else {
          dp[i][j] = (i - 1 >= 0 ? dp[i - 1][j] : 0) + (j - 1 >= 0 ? dp[i][j - 1] : 0);
        }
      }
    }

    return dp[m - 1][n - 1];
  }

  public static void main(String[] args) {
    LC0062 lc = new LC0062();
    System.out.println(lc.uniquePaths(3, 7)); // 28
    System.out.println(lc.uniquePaths(3, 2)); // 3
  }
}
