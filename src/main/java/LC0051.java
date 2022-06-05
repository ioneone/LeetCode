package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two
 * queens attack each other.
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the
 * answer in any order.
 * 
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and
 * '.' both indicate a queen and an empty space, respectively.
 */
public class LC0051 {
  public List<List<String>> solveNQueens(int n) {
    boolean[][] board = new boolean[n][n];

    return helper(0, board, new ArrayList<>());
  }

  public List<List<String>> helper(int row, boolean[][] board, List<String> currSolution) {
    int n = board.length;

    if (row == n) {
      if (!currSolution.isEmpty()) {
        return List.of(new ArrayList<>(currSolution));
      } else {
        return List.of();
      }
    }

    List<List<String>> solutions = new ArrayList<>();

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

        StringBuilder rowStr = new StringBuilder(".".repeat(n));
        rowStr.setCharAt(i, 'Q');

        currSolution.add(rowStr.toString());

        solutions.addAll(helper(row + 1, board, currSolution));

        for (Cell cell : cells) {
          board[cell.row][cell.col] = false;
        }

        currSolution.remove(currSolution.size() - 1);
      }
    }

    return solutions;
  }

  public static record Cell(int row, int col) {
  }

  public static void main(String[] args) {
    LC0051 lc = new LC0051();
    System.out.println(lc.solveNQueens(1)); // 1
    System.out.println(lc.solveNQueens(4)); // 2
  }
}
