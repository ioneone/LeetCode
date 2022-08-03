package main.java;

import java.util.TreeSet;

public class LC0729 {

  private final TreeSet<int[]> books;

  public LC0729() {
    this.books = new TreeSet<>((int[] book1, int[] book2) -> book1[0] - book2[0]);
  }

  public boolean book(int start, int end) {
    int[] newBook = new int[] {start, end};

    int[] floor = this.books.floor(newBook);
    if (floor != null && start < floor[1]) {
      return false;
    }

    int[] ceiling = this.books.ceiling(newBook);
    if (ceiling != null && end > ceiling[0]) {
      return false;
    }

    this.books.add(newBook);

    return true;
  }

  public static void main(String[] args) {
    LC0729 lc = new LC0729();
    System.out.println(lc.book(10, 20)); // true
    System.out.println(lc.book(15, 25)); // false
    System.out.println(lc.book(20, 30)); // true
  }
}
