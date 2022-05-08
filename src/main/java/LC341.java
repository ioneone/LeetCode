package main.java;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists. Implement an iterator to flatten it.
 * 
 * Implement the NestedIterator class:
 * 
 * NestedIterator(List<NestedInteger> nestedList) Initializes the iterator with the nested list nestedList.
 * 
 * int next() Returns the next integer in the nested list. 
 * boolean hasNext() Returns true if there are still some integers in the nested list and false otherwise.
 * Your code will be tested with the following pseudocode:
 * 
 * initialize iterator with nestedList
 * res = []
 * while iterator.hasNext()
 *     append iterator.next() to the end of res
 * return res
 * 
 * If res matches the expected flattened list, then your code will be judged as correct.
 */
public class LC341 implements Iterator<Integer> {

  private Integer cachedNext = null;

  private final Stack<Data> stack;
  
  public LC341(List<NestedInteger> nestedList) {
    this.stack = new Stack<>();

    if (nestedList.size() > 0) {
      this.stack.add(new Data(nestedList, 0));
    }
  }

  @Override
  public Integer next() {
    if (cachedNext != null) {
      Integer ret = cachedNext;
      cachedNext = null;
      return ret;
    }

    if (stack.isEmpty()) {
      return null;
    }

    Data data = stack.pop();

    List<NestedInteger> nestedList = data.nestedList;
    int currentIndex = data.currentIndex;

    NestedInteger nestedInteger = nestedList.get(currentIndex);
    if (nestedInteger.isInteger()) {

      if (currentIndex + 1 < nestedList.size()) {
        stack.add(new Data(nestedList, currentIndex + 1));
      }

      return nestedInteger.getInteger();
    } else {
      
      if (currentIndex + 1 < nestedList.size()) {
        stack.add(new Data(nestedList, currentIndex + 1));
      }

      List<NestedInteger> nextNestedList = nestedInteger.getList();
      if (nextNestedList.size() > 0) {
        stack.add(new Data(nextNestedList, 0));
      }
      
      return next();
    }
    
  }

  @Override
  public boolean hasNext() {
    if (cachedNext != null) {
      return true;
    }

    if (stack.isEmpty()) {
      return false;
    }

    cachedNext = next();

    return cachedNext != null;
  }

  private static class Data {

    public List<NestedInteger> nestedList;
    public int currentIndex;

    public Data(List<NestedInteger> nestedList, int currentIndex) {
      this.nestedList = nestedList;
      this.currentIndex = currentIndex;
    }
  }

  public static class NestedInteger {
    private Integer integer;
    private List<NestedInteger> list;

    public NestedInteger(Integer integer, List<NestedInteger> list) {
      this.integer = integer;
      this.list = list;
    }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {
      return integer != null;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
      return integer;
    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
      return list;
    }
  }

  public static void main(String[] args) {
    // [1, [2]]
    List<NestedInteger> list = List.of(new NestedInteger(1, null), new NestedInteger(null, List.of(new NestedInteger(2, null))));
    LC341 i = new LC341(list);
    while (i.hasNext()) {
      System.out.println(i.next());
    }

    list = List.of(new NestedInteger(null, List.of()));
    i = new LC341(list);
    while (i.hasNext()) {
      System.out.println(i.next());
    }
  }
}