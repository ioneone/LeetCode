package main.java;

import java.util.HashMap;
import java.util.Map;

/**
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such
 * that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 * 
 * F(0) = 0, F(1) = 1 F(n) = F(n - 1) + F(n - 2), for n > 1. Given n, calculate F(n).
 */
public class LC0509 {

  public final Map<Integer, Integer> memory;

  public LC0509() {
    this.memory = new HashMap<>();
  }

  public int fib(int n) {
    if (n == 0) {
      return 0;
    }

    if (n == 1) {
      return 1;
    }

    Integer res = this.memory.get(n);

    if (res != null) {
      return res;
    }

    res = fib(n - 1) + fib(n - 2);

    this.memory.put(n, res);

    return res;
  }

  public static void main(String[] args) {
    LC0509 lc = new LC0509();
    System.out.println(lc.fib(2)); // 1
    System.out.println(lc.fib(3)); // 2
    System.out.println(lc.fib(4)); // 3
  }

}
