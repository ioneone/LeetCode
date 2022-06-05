package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two
 * queens attack each other.
 * 
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 * 
 * https://leetcode.com/problems/n-queens-ii/
 */
public class LC0052 {
  public int totalNQueens(int n) {

    boolean[][] board = new boolean[n][n];

    return helper(0, board);
  }

  public int helper(int row, boolean[][] board) {
    int n = board.length;

    if (row == n) {
      return 1;
    }

    int sum = 0;

    for (int i = 0; i < n; i++) {
      if (!board[row][i]) {

        List<Cell> cells = new ArrayList<>();

        // add down
        for (int j = row + 1; j < n; j++) {
          if (!board[j][i]) {
            cells.add(new Cell(j, i));
          }
        }

        // add left-down
        for (int j = row + 1, k = 1; j < n && i - k >= 0; j++, k++) {
          if (!board[j][i - k]) {
            cells.add(new Cell(j, i - k));
          }
        }

        // add right-down
        for (int j = row + 1, k = 1; j < n && i + k < n; j++, k++) {
          if (!board[j][i + k]) {
            cells.add(new Cell(j, i + k));
          }
        }

        for (Cell cell : cells) {
          board[cell.row][cell.col] = true;
        }

        sum += helper(row + 1, board);

        for (Cell cell : cells) {
          board[cell.row][cell.col] = false;
        }
      }
    }

    return sum;
  }

  public static record Cell(int row, int col) {
  }

  public static void main(String[] args) {
    LC0052 lc = new LC0052();
    System.out.println(lc.totalNQueens(1)); // 1
    System.out.println(lc.totalNQueens(4)); // 2
  }
}
