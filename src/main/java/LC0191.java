package main.java;

public class LC0191 {
  // you need to treat n as an unsigned value
  public int hammingWeight(int n) {
    long x = Integer.toUnsignedLong(n);
    int count = 0;
    while (x != 0) {
      count += x % 2;
      x = x / 2;
    }
    return count;
  }

  public static void main(String[] args) {
    LC0191 lc = new LC0191();
    System.out.println(lc.hammingWeight(11)); // 3
    System.out.println(lc.hammingWeight(128)); // 1
  }
}
