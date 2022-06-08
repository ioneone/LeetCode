package main.java;

/**
 * Given a 2D matrix matrix, handle multiple queries of the following type:
 * 
 * Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner
 * (row1, col1) and lower right corner (row2, col2). Implement the NumMatrix class:
 * 
 * NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix. int
 * sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix
 * inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2,
 * col2).
 */
public class LC0304 {

  private int[][] matrix;
  private int[][] sums;

  public LC0304(int[][] matrix) {
    this.matrix = matrix;

    this.sums = new int[matrix.length][];
    for (int row = 0; row < matrix.length; row++) {
      this.sums[row] = new int[matrix[row].length];
      for (int col = 0; col < matrix[row].length; col++) {
        int sumLeft = col - 1 >= 0 ? this.sums[row][col - 1] : 0;
        int sumTop = row - 1 >= 0 ? this.sums[row - 1][col] : 0;
        int sumTopLeft = row - 1 >= 0 && col - 1 >= 0 ? this.sums[row - 1][col - 1] : 0;
        this.sums[row][col] = sumTop + sumLeft - sumTopLeft + matrix[row][col];
      }
    }

  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    int sum = this.sums[row2][col2];
    int sumTop = row1 - 1 >= 0 ? this.sums[row1 - 1][col2] : 0;
    int sumLeft = col1 - 1 >= 0 ? this.sums[row2][col1 - 1] : 0;
    int sumTopLeft = row1 - 1 >= 0 && col1 - 1 >= 0 ? this.sums[row1 - 1][col1 - 1] : 0;
    return sum - sumTop - sumLeft + sumTopLeft;
  }

  public static void main(String[] args) {
    LC0304 lc = new LC0304(new int[][] {new int[] {3, 0, 1, 4, 2}, new int[] {5, 6, 3, 2, 1},
        new int[] {1, 2, 0, 1, 5}, new int[] {4, 1, 0, 1, 7}, new int[] {1, 0, 3, 0, 5}});
    System.out.println(lc.sumRegion(2, 1, 4, 3)); // 8
    System.out.println(lc.sumRegion(1, 1, 2, 2)); // 11
    System.out.println(lc.sumRegion(1, 2, 2, 4)); // 12
  }
}
